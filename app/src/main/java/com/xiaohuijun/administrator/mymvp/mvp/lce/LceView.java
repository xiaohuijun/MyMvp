package com.xiaohuijun.administrator.mymvp.mvp.lce;

import android.support.annotation.UiThread;

import com.xiaohuijun.administrator.mymvp.mvp.MvpView;

/**
 * Created by Administrator on 2016/8/1.
 */
public interface LceView<M> extends MvpView{

    @UiThread
    public void showLoading();

    @UiThread
    public void dismissLoading();

    @UiThread
    public void showContent(M data);

    @UiThread
    public void showError(String e);
}
