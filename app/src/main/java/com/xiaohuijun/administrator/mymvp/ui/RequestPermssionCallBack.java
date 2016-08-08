package com.xiaohuijun.administrator.mymvp.ui;

/**
 * Created by Administrator on 2016/8/5.
 */
public interface RequestPermssionCallBack {
    //已授权
    public void permissionsGranted();

    //授权失败
    public void permissionsDenied();
}
