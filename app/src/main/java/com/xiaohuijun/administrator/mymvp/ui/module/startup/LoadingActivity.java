package com.xiaohuijun.administrator.mymvp.ui.module.startup;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

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
        startActivity(new Intent(LoadingActivity.this, GuideActivity.class));
        finish();
    }
}
