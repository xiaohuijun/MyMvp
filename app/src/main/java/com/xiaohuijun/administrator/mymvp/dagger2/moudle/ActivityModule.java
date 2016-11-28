package com.xiaohuijun.administrator.mymvp.dagger2.moudle;

import android.app.Activity;

import com.xiaohuijun.administrator.mymvp.dagger2.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：${xiaohuijun} on 2016/11/28 15:21
 * 邮箱：xiaohuijun1992@163.com
 */
@Module
public class ActivityModule {
    private Activity activity;
    public ActivityModule(Activity activity){
        this.activity = activity;
    }

    @ActivityScope
    @Provides
    Activity provideActivity(){
        return activity;
    }
}
