package com.xiaohuijun.administrator.mymvp;

import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.support.multidex.MultiDex;

import com.umeng.socialize.PlatformConfig;

import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiaohuijun
 * @date: 2016/7/1
 * @email: xiaohuijun1992@163.com
 */
public class MyAppliction extends Application {
    private List<Activity> activityList = new LinkedList<Activity>();
    private static MyAppliction instance = null;
    private static Context context = null;

    // 单例模式中获取唯一的MyApplication实例
    public static MyAppliction getInstance() {
        if (instance == null) {
            synchronized (MyAppliction.class) {
                if (instance == null) {
                    instance = new MyAppliction();
                }
            }
        }
        return instance;
    }


    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //开启dex进程的话也会进入application
        if (isDexProcess()) {
            return;
        }
        doInstallBeforeLollipop();
        MultiDex.install(this);
    }

    private boolean isAppFirstInstall() {
        SharedPreferences sharedPreferences = getSharedPreferences("install", Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean("firstInstall", true);
    }

    private void setAppNoteFirstInstall() {
        SharedPreferences sharedPreferences = getSharedPreferences("install", Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("firstInstall", false).commit();
    }

    private boolean existTempFile() {
        String filePath = Environment.getExternalStorageDirectory().toString() + File.separator + "photo.note";
        return new File(filePath).exists();
    }

    private void createTempFile() throws IOException {
        String filePath = Environment.getExternalStorageDirectory().toString() + File.separator + "photo.note";
        File file = new File(filePath);
        if (file.exists()) {
            file.delete();
        }
        file.createNewFile();
    }

    private void startDexProcess() {
        Intent intent = new Intent(this, DexActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    private void doInstallBeforeLollipop() {
        //满足3个条件，1.第一次安装开启，2.主进程，3.API<21(因为21之后ART的速度比dalvik快接近10倍(毕竟5.0之后的手机性能也要好很多))
        if (isAppFirstInstall() && !isDexProcessOrOtherProcesses() && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            try {
                createTempFile();
                startDexProcess();
                while (true) {
                    if (existTempFile()) {
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    } else {
                        setAppNoteFirstInstall();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean isDexProcessOrOtherProcesses() {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (pid == appProcess.pid) {
                if (appProcess.processName.equals("com.yydcdut.note:dex") ||
                        appProcess.processName.equals("com.yydcdut.note:cameraphotos") ||
                        appProcess.processName.equals("com.yydcdut.note:remote") ||
                        appProcess.processName.equals("com.yydcdut.note:makephotos")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isDexProcess() {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (pid == appProcess.pid) {
                if (appProcess.processName.equals("com.yydcdut.note:dex")) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isOtherProcess(String processName) {
        int pid = android.os.Process.myPid();
        ActivityManager activityManager = (ActivityManager) this.getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager.getRunningAppProcesses()) {
            if (pid == appProcess.pid) {
                if (appProcess.processName.equals(processName)) {
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        if (isDexProcess()) {
            return;
        }
        context = getApplicationContext();
        InitIntentService.startActionInit(context);
//
//        //友盟分享配置
//        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
//        //微信 appid appsecret
//        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
//        //新浪微博 appkey appsecret
//        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
//        // QQ和Qzone appid appkey
//        PlatformConfig.setAlipay("2015111700822536");
//        //支付宝 appid

    }

    public static Context getContext() {
        return context;
    }
}
