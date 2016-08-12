package com.xiaohuijun.administrator.mymvp.presenter.User;

import com.xiaohuijun.administrator.mymvp.data.DataRepository;
import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;
import com.xiaohuijun.administrator.mymvp.data.remote.rx.ResponseObserver;
import com.xiaohuijun.administrator.mymvp.data.remote.service.RequestParams;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;

import java.util.HashMap;
import java.util.Map;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class UserPresenter<V extends LceView> implements MvpPresenter<V>{
    private final DataRepository dataSource;

    private LceView mView;
    private Map<String,String> body;
    private CompositeSubscription mSubscriptions;

    public UserPresenter(DataRepository dataSource){
        this.dataSource = dataSource;
    }

    public void loadUserList(){
        body = new HashMap<>();
        body.put("page","1");
        body = RequestParams.getRequestParams(body);
        mView.showLoading();
        mSubscriptions.add(dataSource.getUserList(body)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        mView.dismissLoading();
                    }
                }).subscribe(new ResponseObserver<BaseResponse<UserList>>() {
                    @Override
                    public void onSuccess(BaseResponse<UserList> userListBaseResponse) {
                        mView.showContent(userListBaseResponse);
                    }

                    @Override
                    public void onError(String errorMsg) {
                        mView.showError(errorMsg);
                    }
                })
        );
    }


    public void loadUserInfo(){
        body = RequestParams.getRequestParams(body);
        mView.showLoading();
        mSubscriptions.add(dataSource.getUserInfo(body)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnTerminate(new Action0() {
                    @Override
                    public void call() {
                        mView.dismissLoading();
                    }
                })
                .subscribe(new ResponseObserver<BaseResponse<UserInfo>>() {
                    @Override
                    public void onSuccess(BaseResponse<UserInfo> userInfoBaseResponse) {
                        mView.showContent(userInfoBaseResponse.return_data);
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
        //loadUserList();
    }

    @Override
    public void detachView() {
        mSubscriptions.clear();
    }
}
