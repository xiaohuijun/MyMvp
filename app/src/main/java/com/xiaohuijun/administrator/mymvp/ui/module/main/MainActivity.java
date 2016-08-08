package com.xiaohuijun.administrator.mymvp.ui.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.Glide.ImageLoader;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;
import com.xiaohuijun.administrator.mymvp.common.util.PermissionUtils;
import com.xiaohuijun.administrator.mymvp.data.RepositoryFactory;
import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.mvp.MvpActivity;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;
import com.xiaohuijun.administrator.mymvp.presenter.User.UserPresenter;
import com.xiaohuijun.administrator.mymvp.ui.InitInterface;
import com.xiaohuijun.administrator.mymvp.ui.RequestPermssionCallBack;
import com.xiaohuijun.administrator.mymvp.ui.module.common.FullImageActivity;
import com.xiaohuijun.administrator.progressdialog.svprogresshud.SVProgressHUD;

import butterknife.BindView;

public class MainActivity extends MvpActivity implements LceView<Object>,InitInterface{
    UserPresenter userPresenter;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.age)
    TextView age;
    @BindView(R.id.phone)
    TextView phone;
    @BindView(R.id.user_icon)
    ImageView userIcon;
    @BindView(R.id.test)
    Button test;
    SVProgressHUD progress;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar("main");
        initView();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initData();
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        userPresenter = new UserPresenter(RepositoryFactory.getDataRepository());
        return userPresenter;
    }

    @Override
    public void initView() {
        progress = new SVProgressHUD(MainActivity.this, Gravity.CENTER,false);
        test.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String[] perms = {PermissionUtils.CAMERA};
                needPermssionTask(PermissionUtils.getPermissions(perms), new RequestPermssionCallBack() {
                    @Override
                    public void permissionsGranted() {
                        toastShow("授权成功,do something");
                    }

                    @Override
                    public void permissionsDenied() {
                        toastShow("授权失败,do something");
                    }
                },R.string.rationale_camera);

            }
        });
    }

    @Override
    public void initData() {
         userPresenter.loadUserInfo();
    }

    @Override
    public void showLoading() {
        progress.showWithStatus(getString(R.string.progress_text));
    }

    @Override
    public void dismissLoading() {
        progress.dismiss();
    }

    @Override
    public void showContent(Object data) {
            if (data instanceof UserInfo){
                final UserInfo userInfo= (UserInfo) data;
                MLog.e(userInfo.toString());
                name.setText(userInfo.userName);
                age.setText(userInfo.userBirthday);
                userIcon.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent in = new Intent(MainActivity.this, FullImageActivity.class);
                        in.putExtra("position","1");
                        in.putExtra("picUrl",userInfo.userIco);
                        startActivity(in);
                    }
                });
                ImageLoader.load(MainActivity.this,userInfo.userIco,userIcon,R.mipmap.ic_launcher);
                phone.setText(userInfo.userPhone);

            }
    }

    @Override
    public void showError(String e) {
        MLog.e(e);
    }



}
