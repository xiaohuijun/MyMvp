package com.xiaohuijun.administrator.mymvp.data.remote;

import com.xiaohuijun.administrator.mymvp.data.DataRepository;
import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;
import com.xiaohuijun.administrator.mymvp.data.remote.service.ApiService;

import java.util.Map;

import rx.Observable;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class DataSource implements DataRepository{
    private ApiService myService;
    private static DataSource sInstance;
    public DataSource(){
        myService = RetrofitBuilder.build().create(ApiService.class);
    }

    // 单例模式中获取唯一的MyApplication实例
    public static DataSource getInstance() {
        if (sInstance == null) {
            synchronized (DataSource.class) {
                if (sInstance == null) {
                    sInstance = new DataSource();
                }
            }
        }
        return sInstance;
    }


    @Override
    public Observable<BaseResponse<UserInfo>> getUserInfo(Map<String,String> body) {
        return myService.getUserInfo(body);
    }

    @Override
    public Observable<BaseResponse<UserList>> getUserList(Map<String,String> body) {
        return myService.getUserList(body);
    }
}
