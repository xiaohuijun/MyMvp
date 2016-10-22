package com.xiaohuijun.administrator.mymvp;

public class NetUtils {
    static {
        System.loadLibrary("NetTools");
    }
    public static final String URL_OFFICAL = "URL_OFFICAL";
    public static final String URL_PRE_OFFICAL = "URL_PRE_OFFICAL";
    public static final String URL_LOCAL_TEST = "URL_LOCAL_TEST";

    public static native String getUrl(String urlType, String Suffix);

    public static native String getUrlPortal(String urlType, String Suffix);

    public static native String getHost(String urlType);

    public static native String getHostPortal(String urlType);
}
