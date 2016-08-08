package com.xiaohuijun.administrator.mymvp.data;

import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.data.model.UserList;
import com.xiaohuijun.administrator.mymvp.data.remote.response.BaseResponse;

import java.util.Map;

import rx.Observable;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public interface DataRepository {
    //数据仓库
    //获取用户信息
    Observable<BaseResponse<UserInfo>> getUserInfo(Map<String,String> body);

    Observable<BaseResponse<UserList>> getUserList(Map<String,String> body);
}
