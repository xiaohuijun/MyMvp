package com.xiaohuijun.administrator.mymvp.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.toastcompat.ToastCompat;
import com.xiaohuijun.administrator.mymvp.common.util.AppManager;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;

import java.util.List;

import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class BaseActivity extends AppCompatActivity implements View.OnClickListener,EasyPermissions.PermissionCallbacks{
    public Activity mActivity;
    private static final int RC_PERM = 120;
    public RequestPermssionCallBack hasPermissions;
    public String[] perms;
    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        mActivity = this;
        AppManager.getAppManager().addActivity(this);
    }


    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        ButterKnife.bind(this);
        mActivity = this;
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        ButterKnife.bind(this);
        mActivity = this;
        AppManager.getAppManager().addActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected void onDestroy() {
        onUnsubscribe();
        super.onDestroy();
    }

    @Override
    public void finish() {
        super.finish();
        AppManager.getAppManager().rmoveActivity(this);
    }

    private CompositeSubscription mCompositeSubscription;

    public void onUnsubscribe() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();//取消注册，以避免内存泄露
        }
    }

    public void addSubscription(Subscription subscription) {
//        if (mCompositeSubscription == null) {
        mCompositeSubscription = new CompositeSubscription();
//        }
        mCompositeSubscription.add(subscription);
    }

    public Toolbar initToolBar(String title) {

        Toolbar toolbar = initToolBar();
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(title);
        return toolbar;
    }

    public Toolbar initToolBar(int title) {
        Toolbar toolbar = initToolBar();
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(title);
        return toolbar;
    }

    public Toolbar initToolBar(String title,int imgRight){
        Toolbar toolbar = initToolBar();
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(title);
        return toolbar;
    };

    public Toolbar initToolBar(String title,View viewRight){
        Toolbar toolbar = initToolBar();
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(title);
        return toolbar;
    };

    public Toolbar initToolBar() {

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView toolbar_back= (ImageView) findViewById(R.id.toolbar_back);
        toolbar_back.setOnClickListener(this);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
            actionBar.setDisplayHomeAsUpEnabled(false);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        return toolbar;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {

            case android.R.id.home:
                super.onBackPressed();//返回
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void toastShow(int resId) {
        ToastCompat.makeText(mActivity,mActivity.getString(resId) , Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        ToastCompat.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View view) {
        //返回按钮
        if(view.getId() == R.id.toolbar_back){
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EasyPermissions.SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen
            // Let's show Toast for example
            if(perms!=null && hasPermissions!=null && EasyPermissions.hasPermissions(this,perms)){
                hasPermissions.permissionsGranted();
            }else{
                hasPermissions.permissionsDenied();
            }
        }
    }

    //通用权限请求回调
    @AfterPermissionGranted(RC_PERM)
    public void needPermssionTask(String[] perms,RequestPermssionCallBack requestPermssionCallBack,int resId){
        this.perms = perms;
        this.hasPermissions = requestPermssionCallBack;
        if (EasyPermissions.hasPermissions(this, perms)) {
            // Have permissions, do the thing!
            hasPermissions.permissionsGranted();
        } else {
            // Ask for both permissions
            EasyPermissions.requestPermissions(this, getString(resId),
                    RC_PERM, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);;
    }

    @Override
    public void onPermissionsGranted(int requestCode, List<String> perms) {
        MLog.d("onPermissionsGranted:" + requestCode + ":" + perms.size());
        if(hasPermissions!=null){
            hasPermissions.permissionsGranted();
        }
    }

    @Override
    public void onPermissionsDenied(int requestCode, List<String> perms) {
        MLog.d("onPermissionsDenied:" + requestCode + ":" + perms.size());
        if(hasPermissions!=null){
            hasPermissions.permissionsDenied();
        }
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Let's show a toast
                Toast.makeText(mActivity, R.string.settings_dialog_canceled, Toast.LENGTH_SHORT).show();
            }
        };
        // (Optional) Check whether the user denied permissions and checked NEVER ASK AGAIN.
        // This will display a dialog directing them to enable the permission in app settings.
        EasyPermissions.checkDeniedPermissionsNeverAskAgain(this,
                getString(R.string.rationale_ask_again),
                R.string.setting, R.string.cancel, onClickListener, perms);
    }

}
