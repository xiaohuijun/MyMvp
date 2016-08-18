package com.xiaohuijun.administrator.mymvp.common.Filepicker;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.xiaohuijun.administrator.mymvp.R;

import java.util.ArrayList;



/**
 * 文件选择帮助类
 * @author: xiaohuijun
 * @date: 2016/8/18
 * @email: xiaohuijun1992@163.com
 */
public class FileSelectUtils {

    /**
     * 选择图片
     * @param filePaths
     * @param maxSelectSize
     * @param context
     */
    public static void selectPhoto(ArrayList<String> filePaths, int maxSelectSize, Activity context){
        FilePickerBuilder.getInstance()
                .setMaxCount(maxSelectSize)
                .setSelectedFiles(filePaths)
                .setActivityTheme(R.style.FilePickerTheme)
                .pickPhoto(context);
    }

    /**
     * 选择图片
     * @param filePaths
     * @param maxSelectSize
     * @param context
     */
    public static void selectPhoto(ArrayList<String> filePaths, int maxSelectSize, Fragment context){
        FilePickerBuilder.getInstance()
                .setMaxCount(maxSelectSize)
                .setSelectedFiles(filePaths)
                .setActivityTheme(R.style.FilePickerTheme)
                .pickPhoto(context);
    }


    /**
     * 选择文档
     * @param filePaths
     * @param maxSelectSize
     * @param context
     */
    public static void selectDocument(ArrayList<String> filePaths, int maxSelectSize, Activity context){
        FilePickerBuilder.getInstance()
                .setMaxCount(maxSelectSize)
                .setSelectedFiles(filePaths)
                .setActivityTheme(R.style.FilePickerTheme)
                .pickDocument(context);
    }

    /**
     * 选择文档
     * @param filePaths
     * @param maxSelectSize
     * @param context
     */
    public static void selectDocument(ArrayList<String> filePaths, int maxSelectSize, Fragment context){
        FilePickerBuilder.getInstance()
                .setMaxCount(maxSelectSize)
                .setSelectedFiles(filePaths)
                .setActivityTheme(R.style.FilePickerTheme)
                .pickDocument(context);
    }

}
