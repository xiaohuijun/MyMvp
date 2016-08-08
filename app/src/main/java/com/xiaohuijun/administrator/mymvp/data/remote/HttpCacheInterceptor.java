package com.xiaohuijun.administrator.mymvp.data.remote;

import android.util.Log;
import android.widget.Toast;

import com.xiaohuijun.administrator.mymvp.MyAppliction;
import com.xiaohuijun.administrator.mymvp.common.util.NetWorkHelper;

import java.io.IOException;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2016/7/1.
 */
public class HttpCacheInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        if (!NetWorkHelper.isConnected(MyAppliction.getContext())) {
            request = request.newBuilder()
                    .cacheControl(CacheControl.FORCE_CACHE)
                    .build();
            Toast.makeText(MyAppliction.getContext(),"网络连接异常",Toast.LENGTH_SHORT).show();
            Log.d("com.android.core", "no network");
        }

        Response originalResponse = chain.proceed(request);
        if (NetWorkHelper.isConnected(MyAppliction.getContext())) {
            //有网的时候读接口上的@Headers里的配置，你可以在这里进行统一的设置
            String cacheControl = request.cacheControl().toString();
            return originalResponse.newBuilder()
                    .header("Cache-Control", cacheControl)
                    .removeHeader("Pragma")
                    .build();
        } else {
            return originalResponse.newBuilder()
                    .header("Cache-Control", "public, only-if-cached, max-stale=2419200")
                    .removeHeader("Pragma")
                    .build();
        }
    }
}

