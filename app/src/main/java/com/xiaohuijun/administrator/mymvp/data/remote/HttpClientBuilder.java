package com.xiaohuijun.administrator.mymvp.data.remote;

import com.xiaohuijun.administrator.mymvp.MyAppliction;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by mingjun on 16/7/6.
 */
public class HttpClientBuilder {

    private static final long TIMEOUT_CONNECT = 30 * 1000;

    private static OkHttpClient mClient;

    public static OkHttpClient build() {
        if (mClient == null) {
            File cacheFile = new File(MyAppliction.getContext().getCacheDir(), "babysante");
            Cache cache = new Cache(cacheFile, 1024 * 1024 * 100); //100Mb
            mClient = new OkHttpClient.Builder()
                    .connectTimeout(TIMEOUT_CONNECT, TimeUnit.MILLISECONDS)
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addNetworkInterceptor(new HttpCacheInterceptor())
                    .cache(cache)
                    .build();
        }

        return mClient;
    }
}
