package com.xiaohuijun.administrator.mymvp.data.remote.response;


/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class BaseResponse<T> {
    public int ret;//返回码
    public T return_data;//数据
    public String message;//消息

    @Override
    public String toString() {
        return "返回码："+ret+"数据："+return_data.toString()+"消息："+message;
    }
}
