package com.xiaohuijun.administrator.mymvp.common.Umeng.UmengShareAndLogin;

import android.app.Activity;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMVideo;

/**
 * 友盟分享帮助类
 * @author: xiaohuijun
 * @date: 2016/8/15
 * @email: xiaohuijun1992@163.com
 */
public class UmengShareUtils {

    /**
     * 友盟默认分享
     * @param context
     * @param content
     * @param title
     * @param url
     * @param image
     * @param umShareListener
     */
    public static void umengShare(Activity context, String content, String title, String url, UMImage image, UMShareListener umShareListener){
        final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                {
                        SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.SINA,
                        SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,SHARE_MEDIA.SMS,SHARE_MEDIA.EMAIL,
                        SHARE_MEDIA.ALIPAY
                };
        new ShareAction(context).setDisplayList( displaylist )
                .withText(content)
                .withTitle(title)
                .withTargetUrl(url)
                .withMedia(image)
                .setListenerList(umShareListener)
                .open();
    }

    public static void umengShare(Activity context, String content, String title, String url, UMVideo video, UMShareListener umShareListener){
        final SHARE_MEDIA[] displaylist = new SHARE_MEDIA[]
                {
                        SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE,SHARE_MEDIA.SINA,
                        SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE,SHARE_MEDIA.SMS,SHARE_MEDIA.EMAIL,
                        SHARE_MEDIA.ALIPAY
                };
        new ShareAction(context).setDisplayList( displaylist )
                .withText(content)
                .withTitle(title)
                .withTargetUrl(url)
                .withMedia(video)
                .setListenerList(umShareListener)
                .open();
    }



    /**
     *自定义友盟分享面板
     * @param context
     * @param platform
     * @param content
     * @param title
     * @param url
     * @param image
     * @param umShareListener
     */
    public static void customShare(Activity context,SHARE_MEDIA platform, String content, String title, String url, UMImage image, UMShareListener umShareListener){
        new ShareAction(context)
                .setPlatform(platform)
                .setCallback(umShareListener)
                .withText(content)
                .withTitle(title)
                .withTargetUrl(url)
                .withMedia(image)
                .share();
    }
}
