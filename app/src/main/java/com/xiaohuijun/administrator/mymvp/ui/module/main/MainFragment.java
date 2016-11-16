package com.xiaohuijun.administrator.mymvp.ui.module.main;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.data.RepositoryFactory;
import com.xiaohuijun.administrator.mymvp.mvp.MvpFragment;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;
import com.xiaohuijun.administrator.mymvp.presenter.User.UserPresenter;
import com.xiaohuijun.administrator.mymvp.ui.InitInterface;


public class MainFragment extends MvpFragment implements LceView<Object>, InitInterface {
    private UserPresenter presenter;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
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
