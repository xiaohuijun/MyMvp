package com.xiaohuijun.administrator.mymvp.dagger2.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;
import javax.inject.Singleton;

/**
 * 作者：${xiaohuijun} on 2016/11/28 15:17
 * 邮箱：xiaohuijun1992@163.com
 * app生命周期
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface AppScope {
}
