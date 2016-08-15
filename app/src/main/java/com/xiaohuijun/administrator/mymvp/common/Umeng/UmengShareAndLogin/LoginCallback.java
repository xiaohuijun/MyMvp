package com.xiaohuijun.administrator.mymvp.common.Umeng.UmengShareAndLogin;

import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;

/**
 * 第三方登录回调接口
 * Created by Administrator on 2016/8/15.
 */
public interface LoginCallback {
    //登录成功获取用户信息
    void getUserInfo(UserInfo userInfo);

    //登录出错
    void error(Throwable e);

    //登录取消
    void cancel();

    //未安装对应的app
    void unInstall();
}
