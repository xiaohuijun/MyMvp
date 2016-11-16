package com.xiaohuijun.administrator.mymvp.data.remote.service;

import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Streaming;
import retrofit2.http.Url;
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

    @Multipart
    @POST("uploadurl")
    Observable<BaseResponse<String>> uploadFile(@Part("file")RequestBody body, @Part MultipartBody.Part file);

    @Multipart
    @POST("uploadurl")
    Observable<BaseResponse<String>> uploadFiles(@PartMap Map<String,RequestBody> bodyMap);

    @Multipart
    @POST("uploadurl")
    Observable<BaseResponse<String>> uploadFileWithParams(@QueryMap  Map<String, String> body, @Part MultipartBody.Part file);

    @Multipart
    @POST("uploadurl")
    Observable<BaseResponse<String>> uploadFilesWithParams(@FieldMap Map<String,String> body,@PartMap Map<String,RequestBody> bodyMap);

    @Streaming
    @GET
    Observable<ResponseBody> downloadFile(@Url String   fileUrl);
}
