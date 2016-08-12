package com.xiaohuijun.administrator.mymvp.ui.module.common.EnCode;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.content.ContextCompat;

import com.google.zxing.client.result.ParsedResultType;
import com.mylhyl.zxing.scanner.ScannerView;
import com.mylhyl.zxing.scanner.encode.QREncode;
import com.xiaohuijun.administrator.mymvp.R;

/**
 * @author: xiaohuijun
 * @date: 2016/8/11
 * @email: xiaohuijun1992@163.com
 */
public class EnCodeUtil {
    /**
     * 生成二维码
     * @param context
     * @return
     */
    public static Bitmap getEnCode(Context context) {
        Bitmap bitmap = QREncode.encodeQR(context,
                new QREncode.Builder()
                        .setColor(ContextCompat.getColor(context,R.color.colorPrimary))//二维码颜色
                        .setParsedResultType(ParsedResultType.URI)//二维码类型
                        .setContents("https://github.com/mylhyl")//二维码内容
                        .build());
        return bitmap;
    }

    public static void initScannerView(ScannerView scannerView){
//        toggleLight	切换闪光灯	关false
//        setMediaResId	设置扫描完成播放声音	无
//        setLaserFrameBoundColor	扫描框4角颜色	绿色0xff00ff00
//        setLaserFrameCornerLength	扫描框4角长度	15dp
//        setLaserFrameCornerWidth	扫描框4角宽度	2dp
//        setLaserColor	扫描线颜色	绿色0xff00ff00
//        setLaserLineResId	条形扫描线图片资源	无
//        setLaserGridLineResId	网格扫描线资源	无
//        setLaserLineHeight	扫描线高度	2dp
//        setLaserFrameSize	设置扫描框大小	屏幕5/8
//        setLaserFrameTopMargin	设置扫描框与屏幕距离	屏幕5/8-状态
//        setDrawText	text -> 内容
//        textSize -> 文字大小
//        textColor -> 文字颜色
//        isBottom -> 是否在扫描框下方
//        textMargin -> 离扫描框间距	text -> 将二维码放入框内，即可自动扫描
//        textSize -> 16sp
//        textColor -> 白色
//        isBottom -> true
//        textMargin -> 20d
        scannerView.toggleLight(false);
        //scannerView.setMediaResId();
    }
}
