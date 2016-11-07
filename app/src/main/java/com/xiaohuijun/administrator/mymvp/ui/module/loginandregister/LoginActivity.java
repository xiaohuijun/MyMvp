package com.xiaohuijun.administrator.mymvp.ui.module.loginandregister;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.mvp.MvpActivity;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;

public class LoginActivity extends MvpActivity implements LceView<Object> {
    public static final String CANGOBACK = "canGoBack";
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void dismissLoading() {

    }

    @Override
    public void showContent(Object data) {

    }

    @Override
    public void showError(String e) {

    }
}
