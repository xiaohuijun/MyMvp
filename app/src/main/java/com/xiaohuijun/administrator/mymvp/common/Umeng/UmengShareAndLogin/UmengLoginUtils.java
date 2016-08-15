package com.xiaohuijun.administrator.mymvp.common.Umeng.UmengShareAndLogin;


import android.app.Activity;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.view.UMFriendListener;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;
import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;

import java.util.Map;

/**
 * 友盟第三方登录帮助类
 * @author: xiaohuijun
 * @date: 2016/8/15
 * @email: xiaohuijun1992@163.com
 */
public class UmengLoginUtils {
    private UMShareAPI mShareAPI;
    private SHARE_MEDIA platform;
    private LoginCallback mLoginCallback;
    private Activity context;
    private static volatile UmengLoginUtils instance;
    public UmengLoginUtils(Activity context,SHARE_MEDIA platform, LoginCallback mLoginCallback){
        this.context = context;
        this.platform = platform;
        this.mLoginCallback = mLoginCallback;
        if(mShareAPI==null){
            mShareAPI = UMShareAPI.get(context);
        }
    }
    public static UmengLoginUtils getInstance(Activity context,SHARE_MEDIA platform, LoginCallback mLoginCallback){
        if(instance ==null){
            synchronized (UmengLoginUtils.class){
                if(instance ==null){
                    instance = new UmengLoginUtils(context,platform,mLoginCallback);
                }
            }
        }
        return instance;
    }

    public UMShareAPI getShareAPI(){
        return mShareAPI;
    }

    //授权登录
    public void doOauthLogin(){
        //未安装对应的app
        if(platform == SHARE_MEDIA.WEIXIN || platform == SHARE_MEDIA.QQ || platform == SHARE_MEDIA.QZONE){
            if(!mShareAPI.isInstall(context, platform)) {
                mLoginCallback.unInstall();
            }
        }
        mShareAPI.doOauthVerify(context,platform,umAuthListener);
    }


    private UMAuthListener umAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            MLog.d("Authorize succeed");
            mShareAPI.getPlatformInfo(context,platform,getUserInfoListener);
//            if(platform == SHARE_MEDIA.SINA) {
//                mShareAPI.getFriend(context, platform, getFriendListener);
//            }
        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            MLog.d("Authorize fail");
            mLoginCallback.error(t);
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            MLog.d("Authorize cancel");
            mLoginCallback.cancel();
        }
    };


    private UMAuthListener getUserInfoListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            MLog.d("userInfo succeed");
            /**
             * 此处从map取值转化为userInfo
             */
            UserInfo userInfo= new UserInfo();
            mLoginCallback.getUserInfo(userInfo);
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            MLog.d("userInfo error");
            mLoginCallback.error(throwable);
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            MLog.d("userInfo canel");
            mLoginCallback.cancel();
        }
    };


    private UMFriendListener getFriendListener = new UMFriendListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, Object> map) {
            MLog.d("friend succeed");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            MLog.d("friend error");
            mLoginCallback.error(throwable);
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            MLog.d("friend canel");
            mLoginCallback.cancel();
        }
    };

    //取消某平台的授权
    public void deleteOauth(){
            mShareAPI.deleteOauth(context,platform,umdelAuthListener);
    }

    private  UMAuthListener umdelAuthListener = new UMAuthListener() {
        @Override
        public void onComplete(SHARE_MEDIA share_media, int i, Map<String, String> map) {
            MLog.d("delAuth ok");
        }

        @Override
        public void onError(SHARE_MEDIA share_media, int i, Throwable throwable) {
            MLog.d("delAuth error");
            mLoginCallback.error(throwable);
        }

        @Override
        public void onCancel(SHARE_MEDIA share_media, int i) {
            MLog.d("delAuth canel");
            mLoginCallback.cancel();
        }
    };
}
