package com.xiaohuijun.administrator.mymvp.dagger2.component;

import android.app.Activity;

import com.xiaohuijun.administrator.mymvp.dagger2.moudle.ActivityModule;
import com.xiaohuijun.administrator.mymvp.dagger2.scope.ActivityScope;

import dagger.Component;

/**
 * 作者：${xiaohuijun} on 2016/11/28 15:21
 * 邮箱：xiaohuijun1992@163.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {
        Activity getActivity();
}
