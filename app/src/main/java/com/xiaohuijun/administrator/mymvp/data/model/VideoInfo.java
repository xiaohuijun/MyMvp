package com.xiaohuijun.administrator.mymvp.data.model;

import android.os.Parcelable;

import com.google.auto.value.AutoValue;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;

/**
 * 作者：${xiaohuijun} on 2016/11/16 10:43
 * 邮箱：xiaohuijun1992@163.com
 */
@AutoValue
public abstract class VideoInfo implements Parcelable{
    @SerializedName("id") public abstract int id();
    @SerializedName("title") public abstract String title();
    public static VideoInfo create(int id , String title){
         return new AutoValue_VideoInfo(id,title);
    }

    public static TypeAdapter<VideoInfo> typeAdapter(Gson gson) {
        return new AutoValue_VideoInfo.GsonTypeAdapter(gson);
    }
    public static Builder builder(){
        return  new AutoValue_VideoInfo.Builder();
    }

    @AutoValue.Builder
    public interface Builder{
        Builder id(int id);
        Builder title(String title);
        VideoInfo build();
    }

}
