package com.xiaohuijun.administrator.mymvp.data.remote;

import com.google.gson.TypeAdapterFactory;
import com.ryanharter.auto.value.gson.GsonTypeAdapterFactory;

/**
 * 作者：${xiaohuijun} on 2016/11/16 12:13
 * 邮箱：xiaohuijun1992@163.com
 */
@GsonTypeAdapterFactory
public abstract class MyGosnFactory implements TypeAdapterFactory{
    public static MyGosnFactory create(){
        return new AutoValueGson_MyGosnFactory();
    }
}
