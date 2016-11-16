package com.xiaohuijun.administrator.mymvp.presenter.User;

import com.xiaohuijun.administrator.mymvp.data.DataRepository;
import com.xiaohuijun.administrator.mymvp.data.model.HomeInfo;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;

import java.util.ArrayList;
import java.util.Map;

import rx.subscriptions.CompositeSubscription;

/**
 * 作者：${xiaohuijun} on 2016/11/8 16:10
 * 邮箱：xiaohuijun1992@163.com
 */
public class MainPresenter<V extends LceView> implements MvpPresenter<V>{
    private final DataRepository dataSource;

    private LceView mView;
    private CompositeSubscription mSubscriptions;

    public MainPresenter(DataRepository dataSource){
        this.dataSource = dataSource;
        HomeInfo info = HomeInfo.create(1,"1");
        HomeInfo info1 = HomeInfo.builder().id(1).title("1").build();
        ArrayList<HomeInfo> list = new ArrayList<>();
        list.add(info);
        list.add(info1);
        list.get(0).id();
        list.get(1).id();

    }
    @Override
    public void attachView(V view) {
        mView = view;
        mSubscriptions = new CompositeSubscription();
    }

    @Override
    public void detachView() {
        mSubscriptions.clear();
    }
}
