package com.xiaohuijun.administrator.mymvp.dagger2.component;

import android.app.Activity;

import com.xiaohuijun.administrator.mymvp.dagger2.moudle.ActivityModule;
import com.xiaohuijun.administrator.mymvp.dagger2.moudle.MainModule;
import com.xiaohuijun.administrator.mymvp.dagger2.scope.ActivityScope;
import com.xiaohuijun.administrator.mymvp.ui.module.main.MainActivity;

import dagger.Component;

/**
 * 作者：${xiaohuijun} on 2016/11/28 16:23
 * 邮箱：xiaohuijun1992@163.com
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules ={ActivityModule.class,MainModule.class})
public interface MainComponent  extends  ActivityComponent{
    void inject(MainActivity mainActivity);
}
