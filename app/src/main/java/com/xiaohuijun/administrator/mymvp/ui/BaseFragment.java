package com.xiaohuijun.administrator.mymvp.ui;


import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;

import java.util.List;

import butterknife.ButterKnife;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;
import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * A simple {@link Fragment} subclass.
 */
public class BaseFragment extends Fragment implements EasyPermissions.PermissionCallbacks{
    public Activity mActivity;

    private static final int RC_PERM = 120;
    public RequestPermssionCallBack hasPermissions;
    public String[] perms;
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ButterKnife.bind(this, view);
        mActivity = getActivity();
    }

    public Toolbar initToolBar(View view, String title) {
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        TextView toolbar_title = (TextView) toolbar.findViewById(R.id.toolbar_title);
        toolbar_title.setText(title);
        return toolbar;
    }


    public void toastShow(int resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }

    public void toastShow(String resId) {
        Toast.makeText(mActivity, resId, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        onUnsubscribe();
    }

    private CompositeSubscription mCompositeSubscription;

    public void onUnsubscribe() {
        //取消注册，以避免内存泄露
        if (mCompositeSubscription != null) {
            mCompositeSubscription.unsubscribe();
        }
    }

    public void addSubscription(Subscription subscription) {
//        if (mCompositeSubscription == null) {
        mCompositeSubscription = new CompositeSubscription();
//        }
        mCompositeSubscription.add(subscription);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EasyPermissions.SETTINGS_REQ_CODE) {
            // Do something after user returned from app settings screen
            // Let's show Toast for example
            if(perms!=null && hasPermissions!=null && EasyPermissions.hasPermissions(getContext(),perms)){
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
        if (EasyPermissions.hasPermissions(getContext(), perms)) {
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
        // Handle negative button on click listener
        DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Let's show a toast
                Toast.makeText(getContext(), R.string.settings_dialog_canceled, Toast.LENGTH_SHORT).show();
            }
        };
        // (Optional) Check whether the user denied permissions and checked NEVER ASK AGAIN.
        // This will display a dialog directing them to enable the permission in app settings.
        EasyPermissions.checkDeniedPermissionsNeverAskAgain(this,
                getString(R.string.rationale_ask_again),
                R.string.setting, R.string.cancel, onClickListener, perms);
    }
}
