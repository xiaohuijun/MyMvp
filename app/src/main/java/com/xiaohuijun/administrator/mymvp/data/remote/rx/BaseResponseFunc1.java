package com.xiaohuijun.administrator.mymvp.data.remote.rx;

import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;

import java.util.ArrayList;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Func1;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class BaseResponseFunc1 implements Func1<BaseResponse<UserList>, Observable<ArrayList<UserInfo>>> {

    @Override
    public Observable<ArrayList<UserInfo>> call(final BaseResponse<UserList> userListBaseResponse) {
        return Observable.create(new Observable.OnSubscribe<ArrayList<UserInfo>>() {
            @Override
            public void call(Subscriber<? super ArrayList<UserInfo>> subscriber) {
                if(userListBaseResponse == null){
                    subscriber.onError(new NullPointerException());
                }
                else if(userListBaseResponse.ret == 0) {
                    subscriber.onNext(userListBaseResponse.return_data.userList);
                }
            }
        });
    }
}
