package com.xiaohuijun.administrator.mymvp.common.util;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * activity帮助类
 * @author: xiaohuijun
 * @date: 2016/8/16
 * @email: xiaohuijun1992@163.com
 */
public class ActivityUtils {
    private static ActivityUtils  instance;
    private Activity activity;
    private Intent in;
    public ActivityUtils(Activity activity){
        this.activity = activity;
    }
    public  static ActivityUtils from(Activity activity){
            if(instance == null){
                synchronized (ActivityUtils.class){
                    if(instance == null){
                        instance = new ActivityUtils(activity);
                    }
                }
            }
        return instance;
    }

    public ActivityUtils gotoTargetActivity(Class ActivityClass){
        in = new Intent(activity,ActivityClass);
        return instance;
    }

    public void go(){
        activity.startActivity(in);
    }

    public void goForResult(int requestCode){
        activity.startActivityForResult(in,requestCode);
    }


    public ActivityUtils setAction(String action){
        in.setAction(action);
        return instance;
    }

    public ActivityUtils setData(Uri data){
        in.setData(data);
        return instance;
    }

    public ActivityUtils setDataAndType(Uri data,String type){
        in.setDataAndType(data,type);
        return instance;
    }

    public ActivityUtils setFlags(int flags){
        in.setFlags(flags);
        return instance;
    }

    public ActivityUtils addFlags(int flags){
        in.addFlags(flags);
        return instance;
    }

    public ActivityUtils addCategory(String category){
        in.addCategory(category);
        return instance;
    }

    public ActivityUtils putExtra(String name, boolean value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, byte value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, char value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, short value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, int value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, long value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, float value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, double value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, String value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, CharSequence value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, Parcelable value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, Parcelable[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putParcelableArrayListExtra(String name, ArrayList<? extends Parcelable> value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putIntegerArrayListExtra(String name, ArrayList<Integer> value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putStringArrayListExtra(String name, ArrayList<String> value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putCharSequenceArrayListExtra(String name, ArrayList<CharSequence> value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, Serializable value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, boolean[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, byte[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, short[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, char[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, int[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, long[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, float[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, double[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, String[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, CharSequence[] value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtra(String name, Bundle value) {
        in.putExtra(name,value);
        return instance;
    }

    public ActivityUtils putExtras(Intent src) {
        in.putExtras(src);
        return instance;
    }

    public ActivityUtils putExtras(Bundle extras) {
        in.putExtras(extras);
        return instance;
    }
}
