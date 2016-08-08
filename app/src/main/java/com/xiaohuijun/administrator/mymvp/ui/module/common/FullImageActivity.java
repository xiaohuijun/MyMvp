package com.xiaohuijun.administrator.mymvp.ui.module.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.bm.library.PhotoView;
import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.Glide.ImageLoader;
import com.xiaohuijun.administrator.mymvp.common.util.AppUtils;
import com.xiaohuijun.administrator.mymvp.ui.adapter.BasePageAdapter;

import java.util.ArrayList;

public class FullImageActivity extends Activity {

	private Context context;
	private int position;
	private String picUrl;
	private ArrayList<View> listViews;
	private ImageView[] imageViews;
	private ImageView ivPoint;

	@SuppressWarnings("unchecked")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_full_image);
		context = FullImageActivity.this;
		position = getIntent().getExtras().getInt("position");
		picUrl = getIntent().getStringExtra("picUrl");
		initView();
	}

	private void initView() {
		ViewPager viewPager = (ViewPager) findViewById(R.id.viewPager);
		listViews = new ArrayList<View>();
		LayoutInflater inflater = getLayoutInflater();

		if (picUrl != null) {
			if (picUrl.contains(",")) {
				final String split[] = picUrl.split(",");
				for (int i = 0; i < split.length; i++) {
					View v = inflater.inflate(R.layout.full_image_item, null);
					final PhotoView img = (PhotoView) v.findViewById(R.id.iv_full_image);
					setPhotoViewConfig(img);
					ImageLoader.Load(FullImageActivity.this,split[i],img,R.mipmap.ic_launcher);
					listViews.add(v);
				}
			} else {
				View v = inflater.inflate(R.layout.full_image_item, null);
				PhotoView img = (PhotoView) v.findViewById(R.id.iv_full_image);
				setPhotoViewConfig(img);
				ImageLoader.Load(FullImageActivity.this,picUrl,img,R.mipmap.ic_launcher);
				listViews.add(v);
			}
		}

		LinearLayout linearPoint = (LinearLayout) findViewById(R.id.linear_point);
		imageViews = new ImageView[listViews.size()];
		for (int i = 0; i < listViews.size(); i++) {
			ivPoint = new ImageView(context);
			ivPoint.setLayoutParams(new LayoutParams(LayoutParams.WRAP_CONTENT,
					LayoutParams.WRAP_CONTENT));
			int width = AppUtils.getPhoneWidth(FullImageActivity.this);
			if (width < 720 && width >= 480) {
				ivPoint.setPadding(15, 0, 15, 15);
			} else if (width < 1080 && width >= 720) {
				ivPoint.setPadding(15, 0, 15, 25);
			} else if (width >= 1080) {
				ivPoint.setPadding(15, 0, 15, 45);
			} else {
				ivPoint.setPadding(15, 0, 15, 25);
			}
			imageViews[i] = ivPoint;
			if (i == 0) {
				// 默认进入程序后第一张图片被选中;
				imageViews[i].setImageResource(R.mipmap.sugmama_ponint_selected);
			} else {
				imageViews[i].setImageResource(R.mipmap.sugmama_ponint);
			}
			linearPoint.addView(ivPoint);
		}

		viewPager.setAdapter(new BasePageAdapter(listViews));
		viewPager.setOnPageChangeListener(new OnPageChangeListener() {

			@Override
			public void onPageSelected(int arg0) {
				for (int i = 0; i < imageViews.length; i++) {
					if (arg0 != i) {
						imageViews[i]
								.setImageResource(R.mipmap.sugmama_ponint);
					} else {
						imageViews[i].setImageResource(R.mipmap.sugmama_ponint_selected);
					}
				}
			}

			@Override
			public void onPageScrolled(int arg0, float arg1, int arg2) {
			}

			@Override
			public void onPageScrollStateChanged(int arg0) {
			}
		});
		viewPager.setCurrentItem(position);
	}
	
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode==KeyEvent.KEYCODE_BACK) {
			finish();
		}
		return super.onKeyDown(keyCode, event);
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
