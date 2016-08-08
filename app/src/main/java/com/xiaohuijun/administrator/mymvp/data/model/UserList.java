package com.xiaohuijun.administrator.mymvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class UserList implements Parcelable{
    public int total;//总数
    public ArrayList<UserInfo> userList;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.total);
        parcel.writeTypedList(this.userList);
    }

    public UserList(){};

    protected UserList(Parcel in) {
        this.total = in.readInt();
        this.userList = in.createTypedArrayList(UserInfo.CREATOR);
    }

    public static final Parcelable.Creator<UserList> CREATOR = new Parcelable.Creator<UserList>() {
        @Override
        public UserList createFromParcel(Parcel source) {
            return new UserList(source);
        }

        @Override
        public UserList[] newArray(int size) {
            return new UserList[size];
        }
    };

    @Override
    public String toString() {
        return "总数："+total+"list:"+userList.toString();
    }
}
