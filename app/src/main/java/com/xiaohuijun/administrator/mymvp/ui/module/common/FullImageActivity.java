package com.xiaohuijun.administrator.mymvp.ui.module.common;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.util.AppUtils;
import com.xiaohuijun.administrator.mymvp.ui.adapter.CommonPagerAdapter;
import com.xiaohuijun.administrator.mymvp.ui.adapter.item.AdapterItem;

import java.util.ArrayList;

public class FullImageActivity extends Activity {

	private Context context;
	private int position;
	private String picUrl;
	private ArrayList<String> urls;
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
		urls = new ArrayList<String>();
		LayoutInflater inflater = getLayoutInflater();

		if (picUrl != null) {
			if (picUrl.contains(",")) {
				String split[] = picUrl.split(",");
				for (int i = 0; i < split.length; i++) {
					urls.add(split[i]);
				}
			} else {
				urls.add(picUrl);
			}
		}

		LinearLayout linearPoint = (LinearLayout) findViewById(R.id.linear_point);
		imageViews = new ImageView[urls.size()];
		for (int i = 0; i < urls.size(); i++) {
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

		viewPager.setAdapter(new CommonPagerAdapter<String>(urls,true) {
			@NonNull
			@Override
			public AdapterItem createItem(Object type) {
				return new FullImageItem(FullImageActivity.this);
			}
		});
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
}
