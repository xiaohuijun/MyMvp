package com.xiaohuijun.administrator.mymvp.data.remote;

import com.google.gson.GsonBuilder;
import com.xiaohuijun.administrator.mymvp.data.remote.service.ApiService;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mingjun on 16/6/28.
 */

public class RetrofitBuilder {

    private static Retrofit mRetrofit;

    public static Retrofit build() {
        if (mRetrofit != null) {
            return mRetrofit;
        }
        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(
                new GsonBuilder()
                        .registerTypeAdapterFactory(MyGosnFactory.create())
                        .create());

        mRetrofit = new Retrofit.Builder()
                .baseUrl(ApiService.BASE_URL)
                .client(HttpClientBuilder.build())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build();

        return mRetrofit;
    }
}
