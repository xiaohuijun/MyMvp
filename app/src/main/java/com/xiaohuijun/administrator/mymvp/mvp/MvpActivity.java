package com.xiaohuijun.administrator.mymvp.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.xiaohuijun.administrator.mymvp.ui.BaseActivity;

/**
 * Created by mingjun on 16/7/5.
 */
public abstract class MvpActivity<V extends MvpView, P extends MvpPresenter<V>>
        extends BaseActivity implements MvpView {

    public MvpPresenter mPresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }

        mPresenter.attachView(this);
        setPresenter(mPresenter);
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }

    @Override
    public void setPresenter(MvpPresenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public abstract P createPresenter();
}
