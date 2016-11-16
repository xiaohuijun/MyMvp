package com.xiaohuijun.administrator.mymvp.ui.module.main;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.data.RepositoryFactory;
import com.xiaohuijun.administrator.mymvp.mvp.MvpActivity;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;
import com.xiaohuijun.administrator.mymvp.presenter.User.UserPresenter;
import com.xiaohuijun.administrator.mymvp.ui.InitInterface;

public class Main3Activity extends MvpActivity implements LceView<Object>, InitInterface {
    private UserPresenter presenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        presenter = new UserPresenter(RepositoryFactory.getDataRepository());
        return presenter;
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

    @Override
    public void initView() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void setViewListener() {

    }
}
