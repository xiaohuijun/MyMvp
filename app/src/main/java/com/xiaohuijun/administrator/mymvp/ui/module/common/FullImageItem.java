package com.xiaohuijun.administrator.mymvp.ui.module.common;

import android.app.Activity;
import android.view.View;

import com.bm.library.PhotoView;
import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.Glide.ImageLoader;
import com.xiaohuijun.administrator.mymvp.ui.adapter.item.AdapterItem;

/**
 * @author: xiaohuijun
 * @date: 2016/8/11
 * @email: xiaohuijun1992@163.com
 */
public class FullImageItem implements AdapterItem{
    PhotoView photoView;
    Activity activity;
    public FullImageItem(Activity activity){
        this.activity = activity;
    }
    @Override
    public int getLayoutResId() {
        return R.layout.full_image_item;
    }

    @Override
    public void bindViews(View root) {
        photoView = (PhotoView) root.findViewById(R.id.iv_full_image);
    }

    @Override
    public void setViews() {

    }

    @Override
    public void handleData(Object o, int position) {
        setPhotoViewConfig(photoView);
        ImageLoader.load(activity,String.valueOf(o),photoView,R.mipmap.ic_launcher);
    }


    private void setPhotoViewConfig(PhotoView photoView){
        // 启用图片缩放功能
        photoView.enable();
        // 禁用图片缩放功能 (默认为禁用，会跟普通的ImageView一样，缩放功能需手动调用enable()启用)
        //photoView.disenable();
        // 获取图片信息
        //Info info = photoView.getInfo();
        // 从普通的ImageView中获取Info
        //Info info = PhotoView.getImageViewInfo(ImageView);
        // 从一张图片信息变化到现在的图片，用于图片点击后放大浏览，具体使用可以参照demo的使用
        //photoView.animaFrom(info);
        // 从现在的图片变化到所给定的图片信息，用于图片放大后点击缩小到原来的位置，具体使用可以参照demo的使用
        //photoView.animaTo(info,new Runnable() {
        //	@Override
        //	public void run() {
        //		//动画完成监听
        //	}
        //});
        // 获取/设置 动画持续时间
        //photoView.setAnimaDuring(200);
        //int d = photoView.getAnimaDuring();
        // 获取/设置 最大缩放倍数
        //photoView.setMaxScale(2);
        //float maxScale = photoView.getMaxScale();
        // 设置动画的插入器
        //photoView.setInterpolator(interpolator);
    }
}
