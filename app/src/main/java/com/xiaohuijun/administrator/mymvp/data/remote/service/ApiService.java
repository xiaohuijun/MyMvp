package com.xiaohuijun.administrator.mymvp.data.remote.service;

import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;

import java.util.Map;

import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 * api接口
 */
public interface ApiService {
    public static final String BASE_URL = "http://app.babysante.com/";
    @FormUrlEncoded
    @POST("user/getinfo18")
    Observable<BaseResponse<UserInfo>> getUserInfo(@FieldMap Map<String,String> body);

    @FormUrlEncoded
    @POST("user/getinfo18")
    Observable<BaseResponse<UserList>> getUserList(@FieldMap Map<String,String> body);
}
