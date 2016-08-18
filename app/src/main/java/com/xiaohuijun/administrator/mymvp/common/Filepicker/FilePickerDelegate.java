package com.xiaohuijun.administrator.mymvp.common.Filepicker;

import android.app.Application;

import com.xiaohuijun.administrator.mymvp.common.Filepicker.utils.image.FrescoManager;

/**
 * Created by droidNinja on 14/06/16.
 */
public class FilePickerDelegate extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FrescoManager.init(this);
    }
}
