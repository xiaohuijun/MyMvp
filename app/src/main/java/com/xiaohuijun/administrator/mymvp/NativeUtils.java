package com.xiaohuijun.administrator.mymvp;

/**
 * 作者：${xiaohuijun} on 2016/10/28 17:54
 * 邮箱：xiaohuijun1992@163.com
 */
public class NativeUtils {
    static {
        System.loadLibrary("NativeExample");
    }

    public static native String getStringFromNative();
}
