package com.xiaohuijun.administrator.mymvp.data.remote.rx;


import com.xiaohuijun.administrator.mymvp.common.util.MLog;

import org.json.JSONException;

import retrofit2.adapter.rxjava.HttpException;
import rx.Subscriber;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public abstract class ResponseObserver<T> extends Subscriber<T>{
    @Override
    public void onCompleted() {
        MLog.d("onCompleted");
    }

    @Override
    public void onError(Throwable e) {
        MLog.d("onError"+e.getMessage());
        if (e instanceof HttpException) {
            HttpException httpException = (HttpException) e;
            //httpException.response().errorBody().string()
            int code = httpException.code();
            String msg = httpException.getMessage();
            MLog.e(code+msg);
            if (code != 200) {
                msg = "服务器繁忙！";
            }
            onError(msg);
        }else if(e instanceof JSONException){
            onError("数据格式异常！");
        } else {
            onError(e.getMessage());
        }
    }

    @Override
    public void onNext(T t) {
        onSuccess(t);
    }

    public abstract void onSuccess(T t);

    public abstract void onError(String errorMsg);
}
