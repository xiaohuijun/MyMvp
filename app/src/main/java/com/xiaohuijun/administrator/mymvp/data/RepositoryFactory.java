package com.xiaohuijun.administrator.mymvp.data;

import com.xiaohuijun.administrator.mymvp.data.remote.DataSource;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class RepositoryFactory {

    public static DataRepository getDataRepository(){
        return DataSource.getInstance();
    }
}
