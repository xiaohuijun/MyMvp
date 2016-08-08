package com.xiaohuijun.administrator.mymvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author: xiaohuijun
 * @date: 2016/8/1
 * @email: xiaohuijun1992@163.com
 */
public class UserInfo implements Parcelable{
    public String userID;//:用户的ID
    public String userName;//：用户名称
    public String nickName;//：用户昵称
    public String userSex;//：用户性别，0-男，1-女
    public String userPhone;//：用户手机号
    public String userBirthday;//：用户生日
    public String userIco;//：用户头像URL
    public String userAddress;// 用户地址
    public String weight;//： 孕前 体重
    public String height;//： 孕前 身高
    public String babyWeight;//：宝宝 出生 体重
    public String babyHeight;//：宝宝 出生 身长
    public String babyIco;//  : 宝宝头像
    public String babyNickName;//  : 宝宝昵称
    public String babySex;//  : 宝宝性别
    public String babyBirthday;//  : 宝宝生日
    public String cWeight;//： 当前

    public UserInfo(){};


    protected UserInfo(Parcel in) {
        userID = in.readString();
        userName = in.readString();
        nickName = in.readString();
        userSex = in.readString();
        userPhone = in.readString();
        userBirthday = in.readString();
        userIco = in.readString();
        userAddress = in.readString();
        weight = in.readString();
        height = in.readString();
        babyWeight = in.readString();
        babyHeight = in.readString();
        babyIco = in.readString();
        babyNickName = in.readString();
        babySex = in.readString();
        babyBirthday = in.readString();
        cWeight = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(userID);
        dest.writeString(userName);
        dest.writeString(nickName);
        dest.writeString(userSex);
        dest.writeString(userPhone);
        dest.writeString(userBirthday);
        dest.writeString(userIco);
        dest.writeString(userAddress);
        dest.writeString(weight);
        dest.writeString(height);
        dest.writeString(babyWeight);
        dest.writeString(babyHeight);
        dest.writeString(babyIco);
        dest.writeString(babyNickName);
        dest.writeString(babySex);
        dest.writeString(babyBirthday);
        dest.writeString(cWeight);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<UserInfo> CREATOR = new Creator<UserInfo>() {
        @Override
        public UserInfo createFromParcel(Parcel in) {
            return new UserInfo(in);
        }

        @Override
        public UserInfo[] newArray(int size) {
            return new UserInfo[size];
        }
    };

    @Override
    public String toString() {
        return "姓名："+userName+"电话:"+userPhone+"年龄："+userBirthday;
    }
}
