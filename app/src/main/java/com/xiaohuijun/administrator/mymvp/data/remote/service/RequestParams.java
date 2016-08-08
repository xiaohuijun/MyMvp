package com.xiaohuijun.administrator.mymvp.data.remote.service;

import com.xiaohuijun.administrator.mymvp.MyAppliction;
import com.xiaohuijun.administrator.mymvp.common.AppConfig;
import com.xiaohuijun.administrator.mymvp.common.util.AppUtils;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class RequestParams {

  public static Map<String,String> getRequestParams(Map<String,String> options){
      if(options==null){
          options = new HashMap<>();
      }
      /* 定义TreeMap容器实例，用于装载请求参数 */
      TreeMap<String, String> paramsMap = new TreeMap<String, String>();
      String userID = "1035";
      userID = userID == null ? "" : userID;
      String udid = AppUtils.getImsi(MyAppliction.getContext());
      MLog.e(udid);
      String version =  AppUtils.getAppVersionName(MyAppliction.getContext());
      paramsMap.put("userID", userID);
      paramsMap.put("platformID","2");
      paramsMap.put("version", version);
      paramsMap.put("udid", udid);

      // 调用SDK方法，获得参数签名值
      @SuppressWarnings("deprecation")
      String signature = URLEncoder.encode(ParamSign
              .value(paramsMap, AppConfig.APP_SERECT));

      //添加固定参数
      options.put("userID",userID);
      options.put("platformID","2");
      options.put("version", version);
      options.put("udid", udid);
      options.put("signature",signature);
      return options;
  }
}
