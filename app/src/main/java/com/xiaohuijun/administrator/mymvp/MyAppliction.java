package com.xiaohuijun.administrator.mymvp;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

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
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        context = getApplicationContext();

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
