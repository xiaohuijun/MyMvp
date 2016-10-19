package com.xiaohuijun.administrator.mymvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.umeng.socialize.PlatformConfig;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: xiaohuijun
 * @date: 2016/7/1
 * @email: xiaohuijun1992@163.com
 */
public class MyAppliction extends Application{
    private List<Activity> activityList = new LinkedList<Activity>();
    private static  MyAppliction instance =null;
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
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        context = getApplicationContext();

        //友盟分享配置
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3921700954","04b48b094faeb16683c32669824ebdad");
        //新浪微博 appkey appsecret
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // QQ和Qzone appid appkey
        PlatformConfig.setAlipay("2015111700822536");
        //支付宝 appid

    }

    public static Context getContext(){
        return context;
    }
    // 添加Activity到容器中
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    public void exitOne(Class<?> ctx){
        for (int i = 0; i < activityList.size(); i++) {
            if(activityList.get(i).getClass().getName().equals(ctx.getName()))
                activityList.get(i).finish();
        }
    }

    // 遍历所有Activity并finish
    public void exitAll() {


        for (Activity activity : activityList) {
            activity.finish();

        }

        System.exit(0);

    }
    // 遍历所有Activity并finish
    public void exitAllNoExit() {


        for (Activity activity : activityList) {
            activity.finish();

        }


    }

    //除当前activity外 关闭其他所有的
    public void exitOnlyOne(Activity ctx) {


        for (int i = 0; i < activityList.size(); i++) {
            if(activityList.get(i).getClass().getName().equals(ctx.getClass().getName()))
            {

            }else{
                activityList.get(i).finish();
            }
        }

        System.exit(0);

    }
}
