package com.xiaohuijun.administrator.mymvp.ui.module.startup;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.util.ActivityUtils;
import com.xiaohuijun.administrator.mymvp.ui.module.main.MainActivity;

/**
 * 秒开loading页
 * @author: xiaohuijun
 * @date: 2016/8/16
 * @email: xiaohuijun1992@163.com
 */
public class LoadingActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //延迟加载加过场动画解决6.0页面闪的问题
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ActivityUtils.from(LoadingActivity.this)
                        .gotoTargetActivity(MainActivity.class)
                        .go();
                finish();
                overridePendingTransition(R.anim.stand,R.anim.splash);
            }
        },1);

    }
}
