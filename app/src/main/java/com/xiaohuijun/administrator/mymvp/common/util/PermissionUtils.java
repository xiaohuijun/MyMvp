package com.xiaohuijun.administrator.mymvp.common.util;

import android.Manifest;

/**
 * 需要用户授权的权限列表
 * @author: xiaohuijun
 * @date: 2016/8/5
 * @email: xiaohuijun1992@163.com
 */
public class PermissionUtils {

        public static final String CONTACTS = "contacts";
        public static final String PHONE = "phone";
        public static final String CALENDAR = "calendar";
        public static final String CAMERA = "camera";
        public static final String SENSORS = "sensors";
        public static final String LOCATION = "location";
        public static final String STORAGE = "storage";
        public static final String MICROPHONE = "microphone";
        public static final String SMS = "sms";



    public static String[]  getPermissions(String[] perms){
        String[] permssions = new String[perms.length];
        for (int i=0;i<perms.length;i++){
            if(perms[i].equals(CONTACTS)){
                permssions[i]= getContacts();
            }else if (perms[i].equals(PHONE)){
                permssions[i]= getPhone();
            }else if (perms[i].equals(CALENDAR)){
                permssions[i] = getCalendar();
            }else if (perms[i].equals(CAMERA)){
                permssions[i] = getCamera();
            }else if (perms[i].equals(SENSORS)){
                permssions[i] = getSensors();
            }else if (perms[i].equals(LOCATION)){
                permssions[i] = getLocation();
            }else if (perms[i].equals(STORAGE)){
                permssions[i] = getStorage();
            }else if (perms[i].equals(MICROPHONE)){
                permssions[i] = getMicrophone();
            }else if (perms[i].equals(SMS)){
                permssions[i] = getSms();
            }
        }
        return permssions;
    }

    //<!--危险权限 调用时需要用户授权-->
    //<!--group:android.permission-group.CONTACTS 联系人-->
    public static  String getContacts(){
       // <!--<uses-permission android:name="android.permission.WRITE_CONTACTS"/>-->
       // <!--<uses-permission android:name="android.permission.WRITE_CONTACTS"/>-->
       // <!--<uses-permission android:name="android.permission.GET_ACCOUNTS"/>-->
       // <!--<uses-permission android:name="android.permission.READ_CONTACTS"/>-->
        return Manifest.permission.READ_CONTACTS;
    }


    //<!--group:android.permission-group.PHONE 拨号和管理电话-->
    public static String getPhone(){
        //<!--<uses-permission android:name="android.permission.READ_CALL_LOG"/>-->
        //<uses-permission android:name="android.permission.READ_PHONE_STATE"/>
        //<!--<uses-permission android:name="android.permission.CALL_PHONE"/>-->
        //<!--<uses-permission android:name="android.permission.WRITE_CALL_LOG"/>-->
        //<!--<uses-permission android:name="android.permission.USE_SIP"/>-->
        //<!--<uses-permission android:name="android.permission.PROCESS_OUTGOING_CALLS"/>-->
        //<!--<uses-permission android:name="com.android.voicemail.permission.ADD_VOICEMAIL"/>-->
        return Manifest.permission.READ_PHONE_STATE;
    }


    //<!--group:android.permission-group.CALENDAR 日历-->
    public static String getCalendar(){
        //<!--<uses-permission android:name="android.permission.READ_CALENDAR"/>-->
        //<!--<uses-permission android:name="android.permission.WRITE_CALENDAR"/>-->
        return Manifest.permission.READ_CALENDAR;
    }


    //<!--group:android.permission-group.CAMERA 相机-->
    public static String getCamera() {
        //<uses - permission android:name = "android.permission.CAMERA" / >
        return Manifest.permission.CAMERA;
    }

    //<!--group:android.permission-group.SENSORS 传感器 心率等-->
    public static String getSensors() {
        //<!-- < uses - permission android:name = "android.permission.BODY_SENSORS" / > -- >
        return Manifest.permission.BODY_SENSORS;
    }

    //<!--group:android.permission-group.LOCATION 位置-->
    public static String getLocation(){
        //<uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"/>
        //<!--<uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"/>-->
        return Manifest.permission.ACCESS_COARSE_LOCATION;
    }


    //<!--group:android.permission-group.STORAGE 访问照片，媒体和文件-->
    public static String getStorage(){
        //<!--<uses-permission android:name="android.permission.READ_EXTERNAL_STORAGE"/>-->
        //<uses-permission android:name="android.permission.WRITE_EXTERNAL_STORAGE"/>
        return Manifest.permission.READ_EXTERNAL_STORAGE;
    }


    //<!--group:android.permission-group.MICROPHONE 话筒 音频记录-->
    public static String getMicrophone(){
        //<uses-permission android:name="android.permission.RECORD_AUDIO"/>
        return Manifest.permission.RECORD_AUDIO;
    }

    //<!--group:android.permission-group.SMS 短信-->
    public static String getSms(){
        //<!--<uses-permission android:name="android.permission.READ_SMS"/>-->
        //<!--<uses-permission android:name="android.permission.RECEIVE_WAP_PUSH"/>-->
        //<!--<uses-permission android:name="android.permission.RECEIVE_MMS"/>-->
        //<!--<uses-permission android:name="android.permission.RECEIVE_SMS"/>-->
        //<!--<uses-permission android:name="android.permission.SEND_SMS"/>-->
        //<!--<uses-permission android:name="android.permission.READ_CELL_BROADCASTS"/>-->
        return  Manifest.permission.READ_SMS;
    }

}
