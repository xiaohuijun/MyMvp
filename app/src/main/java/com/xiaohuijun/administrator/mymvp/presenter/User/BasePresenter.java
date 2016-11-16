package com.xiaohuijun.administrator.mymvp.presenter.User;

import com.xiaohuijun.administrator.mymvp.data.DataRepository;
import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;
import com.xiaohuijun.administrator.mymvp.data.remote.rx.ResponseObserver;
import com.xiaohuijun.administrator.mymvp.data.remote.service.RequestParams;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.MvpView;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;

import java.util.HashMap;
import java.util.Map;

import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.Subscriptions;

/**
 * 作者：${xiaohuijun} on 2016/11/15 13:56
 * 邮箱：xiaohuijun1992@163.com
 */
public class BasePresenter<V extends LceView> implements MvpPresenter<V>{
    private final DataRepository dataSource;
    private LceView mView;
    private Map<String,String> body;
    private CompositeSubscription mSubscriptions;

    public BasePresenter(DataRepository dataSource){
        this.dataSource = dataSource;
    }

    public void startLoad(Observable o){
        mView.showLoading();
        mSubscriptions.add(o
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        mView.dismissLoading();
                    }
                }).subscribe(new ResponseObserver<BaseResponse>() {
                    @Override
                    public void onSuccess(BaseResponse tBaseResponse) {

                        mView.showContent(tBaseResponse.return_data);
                    }

                    @Override
                    public void onError(String errorMsg) {
                        mView.showError(errorMsg);
                    }
                })
        );
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
