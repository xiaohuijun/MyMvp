package com.xiaohuijun.administrator.mymvp.data.remote.service;

import com.xiaohuijun.administrator.mymvp.MyAppliction;
import com.xiaohuijun.administrator.mymvp.common.AppConfig;
import com.xiaohuijun.administrator.mymvp.common.util.AppUtils;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;

import java.io.File;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Multipart;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class RequestParams {

    public static Map<String, String> getRequestParams(Map<String, String> options) {
        if (options == null) {
            options = new HashMap<>();
        }
      /* 定义TreeMap容器实例，用于装载请求参数 */
        TreeMap<String, String> paramsMap = new TreeMap<String, String>();
        String userID = "1035";
        userID = userID == null ? "" : userID;
        String udid = AppUtils.getImsi(MyAppliction.getContext());
        MLog.e(udid);
        String version = AppUtils.getAppVersionName(MyAppliction.getContext());
        paramsMap.put("userID", userID);
        paramsMap.put("platformID", "2");
        paramsMap.put("version", version);
        paramsMap.put("udid", udid);

        // 调用SDK方法，获得参数签名值
        @SuppressWarnings("deprecation")
        String signature = URLEncoder.encode(ParamSign
                .value(paramsMap, AppConfig.APP_SERECT));

        //添加固定参数
        options.put("userID", userID);
        options.put("platformID", "2");
        options.put("version", version);
        options.put("udid", udid);
        options.put("signature", signature);
        return options;
    }

    public static RequestBody getRequestBody(String descriptionString) {
        // 添加描述
        RequestBody description =
                RequestBody.create(
                        MediaType.parse("multipart/form-data"), descriptionString);
        return description;
    }

    public static MultipartBody.Part getPartBody(String fileName, File file) {

        // 创建 RequestBody，用于封装 请求RequestBody
        RequestBody requestFile = RequestBody.create(MediaType.parse("multipart/form-data"), file);
        // MultipartBody.Part is used to send also the actual file name
        MultipartBody.Part body =
                MultipartBody.Part.createFormData(fileName, file.getName(), requestFile);
        return body;
    }

    class ContentType {
        public static final String HTML = "text/html";
        public static final String IMAGE = "image/*";
    }

}
