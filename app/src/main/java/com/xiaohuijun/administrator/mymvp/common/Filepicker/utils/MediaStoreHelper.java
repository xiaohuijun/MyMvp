package com.xiaohuijun.administrator.mymvp.common.Filepicker.utils;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.xiaohuijun.administrator.mymvp.common.Filepicker.cursors.DocScannerTask;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.cursors.loadercallbacks.FileResultCallback;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.cursors.loadercallbacks.PhotoDirLoaderCallbacks;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.models.Document;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.models.PhotoDirectory;

public class MediaStoreHelper {

  public static void getPhotoDirs(FragmentActivity activity, Bundle args, FileResultCallback<PhotoDirectory> resultCallback) {
    activity.getSupportLoaderManager()
        .initLoader(0, args, new PhotoDirLoaderCallbacks(activity, resultCallback));
  }

  public static void getDocs(FragmentActivity activity, FileResultCallback<Document> fileResultCallback)
  {
    new DocScannerTask(activity,fileResultCallback).execute();
  }
}