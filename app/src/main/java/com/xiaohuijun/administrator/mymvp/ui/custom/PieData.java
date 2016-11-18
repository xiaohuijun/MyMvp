package com.xiaohuijun.administrator.mymvp.ui.custom;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;

/**
 * 作者：${xiaohuijun} on 2016/11/17 14:24
 * 邮箱：xiaohuijun1992@163.com
 */
@AutoValue
public abstract class PieData implements Parcelable{
    public abstract String name();
    public abstract float value();
    public abstract float percent();
    public abstract int color();
    public abstract float angle();
    public static PieData create(String name,float percent,float value,int color,float angle){
        return new AutoValue_PieData(name,percent,value,color,angle);
    }

    public static Builder Bulider(){
        return new AutoValue_PieData.Builder();
    }

    @AutoValue.Builder
    public interface Builder{
        Builder name(String name);
        Builder value(float value);
        Builder percent(float percent);
        Builder color(int color);
        Builder angle(float angle);
        PieData build();
    }
}
