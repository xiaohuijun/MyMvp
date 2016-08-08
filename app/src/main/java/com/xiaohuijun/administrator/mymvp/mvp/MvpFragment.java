package com.xiaohuijun.administrator.mymvp.mvp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;

import com.xiaohuijun.administrator.mymvp.ui.BaseFragment;

/**
 * Created by mingjun on 16/7/5.
 */
public abstract class MvpFragment<V extends MvpView, P extends MvpPresenter<V>>
        extends BaseFragment implements MvpView {

    public MvpPresenter mPresenter;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (mPresenter == null) {
            mPresenter = createPresenter();
        }

        setPresenter(mPresenter);
        mPresenter.attachView(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.detachView();
        }
    }

    @Override
    public void setPresenter(MvpPresenter presenter) {
        this.mPresenter = presenter;
    }

    @NonNull
    @Override
    public abstract P createPresenter();
}
