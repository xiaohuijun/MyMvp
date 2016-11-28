package com.xiaohuijun.administrator.mymvp.dagger2.component;

import android.content.Context;

import com.xiaohuijun.administrator.mymvp.dagger2.moudle.AppModule;
import com.xiaohuijun.administrator.mymvp.dagger2.scope.AppScope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者：${xiaohuijun} on 2016/11/28 14:21
 * 邮箱：xiaohuijun1992@163.com
 */
@AppScope
@Component(modules = AppModule.class)
public interface AppComponent {
    Context getContext();

}
