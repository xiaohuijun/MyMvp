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
import com.xiaohuijun.administrator.mymvp.common.RxBus.RxBus;
import com.xiaohuijun.administrator.mymvp.common.RxBus.RxBusSubscriber;
import com.xiaohuijun.administrator.mymvp.common.RxBus.helper.RxSubscriptions;
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
import rx.Subscription;
import rx.functions.Func1;

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
    @BindView(R.id.test_rxbus)
    Button test_rxbus;
    @BindView(R.id.rxbus_text)
    TextView rxbus_text;
    private Subscription mRxSub, mRxSubSticky;
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

        test_rxbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(in);
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

    public void subEvent(){
        RxSubscriptions.remove(mRxSub);
        mRxSub = RxBus.getDefault().toObservable(Bundle.class)
                .map(new Func1<Bundle, Bundle>() {
                    @Override
                    public Bundle call(Bundle bundle) {
                        return bundle;
                    }
                }).subscribe(new RxBusSubscriber<Bundle>() {
                    @Override
                    protected void onEvent(Bundle bundle) {
                        rxbus_text.setText(bundle.getString("event"));
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                        /**
                         * 这里注意: 一旦订阅过程中发生异常,走到onError,则代表此次订阅事件完成,后续将收不到onNext()事件,
                         * 即 接受不到后续的任何事件,实际环境中,我们需要在onError里 重新订阅事件!
                         */
                        subEvent();
                    }
                });
        RxSubscriptions.add(mRxSub);
    }

    public void  subEventSticky(){
        //RxSubscriptions.remove(mRxSubSticky);
        mRxSubSticky = RxBus.getDefault().toObservableSticky(Bundle.class)
                .map(new Func1<Bundle, Bundle>() {
                    @Override
                    public Bundle call(Bundle bundle) {
                        return bundle;
                    }
                }).subscribe(new RxBusSubscriber<Bundle>() {
                    @Override
                    protected void onEvent(Bundle bundle) {
                        rxbus_text.setText(bundle.getString("event_sticky"));
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                });
        RxSubscriptions.add(mRxSubSticky);
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        RxSubscriptions.remove(mRxSub);
        RxSubscriptions.remove(mRxSubSticky);
    }
}
