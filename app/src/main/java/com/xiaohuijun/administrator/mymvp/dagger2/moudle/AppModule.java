package com.xiaohuijun.administrator.mymvp.dagger2.moudle;

import android.content.Context;

import com.xiaohuijun.administrator.mymvp.MyAppliction;
import com.xiaohuijun.administrator.mymvp.dagger2.scope.AppScope;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：${xiaohuijun} on 2016/11/28 14:22
 * 邮箱：xiaohuijun1992@163.com
 */
@Module
public class AppModule {
    private MyAppliction myAppliction;

    public  AppModule(MyAppliction myAppliction){
        this.myAppliction = myAppliction;
    }

    @AppScope
    @Provides
    Context provideAppLicationContext(){
        return myAppliction;
    }
}
