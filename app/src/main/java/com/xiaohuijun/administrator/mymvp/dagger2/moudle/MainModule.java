package com.xiaohuijun.administrator.mymvp.dagger2.moudle;

import com.xiaohuijun.administrator.mymvp.dagger2.scope.ActivityScope;
import com.xiaohuijun.administrator.mymvp.data.DataRepository;
import com.xiaohuijun.administrator.mymvp.data.RepositoryFactory;
import com.xiaohuijun.administrator.mymvp.presenter.User.UserPresenter;
import com.xiaohuijun.administrator.mymvp.ui.module.main.MainActivity;

import dagger.Module;
import dagger.Provides;

/**
 * 作者：${xiaohuijun} on 2016/11/28 16:24
 * 邮箱：xiaohuijun1992@163.com
 */
@Module
public class MainModule {
    private MainActivity mainActivity;
    public MainModule(MainActivity mainActivity){
        this.mainActivity = mainActivity;
    }

    @Provides
    MainActivity provideMainActivity(){
        return mainActivity;
    }

    @Provides
    UserPresenter provideUserPresenter(DataRepository dataSource){
        return new UserPresenter(dataSource);
    }

    @Provides
    DataRepository provideDataRepository(){
        return RepositoryFactory.getDataRepository();
    }
}
