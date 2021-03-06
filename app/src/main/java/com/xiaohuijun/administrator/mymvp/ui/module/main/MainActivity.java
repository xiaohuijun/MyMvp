package com.xiaohuijun.administrator.mymvp.ui.module.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.tencent.openqq.protocol.imsdk.msg;
import com.xiaohuijun.administrator.mymvp.MyAppliction;
import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.FilePickerConst;
import com.xiaohuijun.administrator.mymvp.common.Filepicker.FileSelectUtils;
import com.xiaohuijun.administrator.mymvp.common.Glide.ImageLoader;
import com.xiaohuijun.administrator.mymvp.common.RxBus.RxBus;
import com.xiaohuijun.administrator.mymvp.common.RxBus.RxBusSubscriber;
import com.xiaohuijun.administrator.mymvp.common.RxBus.helper.RxSubscriptions;
import com.xiaohuijun.administrator.mymvp.common.util.ActivityUtils;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;
import com.xiaohuijun.administrator.mymvp.common.util.PermissionUtils;
import com.xiaohuijun.administrator.mymvp.dagger2.component.AppComponent;
import com.xiaohuijun.administrator.mymvp.dagger2.component.DaggerMainComponent;
import com.xiaohuijun.administrator.mymvp.dagger2.moudle.ActivityModule;
import com.xiaohuijun.administrator.mymvp.dagger2.moudle.MainModule;
import com.xiaohuijun.administrator.mymvp.data.RepositoryFactory;
import com.xiaohuijun.administrator.mymvp.data.model.UserInfo;
import com.xiaohuijun.administrator.mymvp.mvp.MvpActivity;
import com.xiaohuijun.administrator.mymvp.mvp.MvpPresenter;
import com.xiaohuijun.administrator.mymvp.mvp.lce.LceView;
import com.xiaohuijun.administrator.mymvp.presenter.User.UserPresenter;
import com.xiaohuijun.administrator.mymvp.ui.InitInterface;
import com.xiaohuijun.administrator.mymvp.ui.RequestPermssionCallBack;
import com.xiaohuijun.administrator.mymvp.ui.module.common.EnCode.EnCodeActivity;
import com.xiaohuijun.administrator.mymvp.ui.module.common.FullImageActivity;
import com.xiaohuijun.administrator.progressdialog.svprogresshud.SVProgressHUD;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import rx.Subscription;
import rx.functions.Func1;

public class MainActivity extends MvpActivity implements LceView<Object>, InitInterface {
    @Inject
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
    @BindView(R.id.choose_photo_btn)
    Button chooseImgBtn;
    @BindView(R.id.choose_doc_btn)
    Button chooseDocBtn;
    @BindView(R.id.encode_btn)
    Button encode_btn;
    private Subscription mRxSub, mRxSubSticky;
    private ArrayList<String> filePaths;

    @BindView(R.id.bind_text1)
    TextView bindText1;

    @BindView(R.id.tv_rv)
    TextView tvRv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolBar("main");
        initView();
        subEvent();
        initDagger();
    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        initData();
    }

    @NonNull
    @Override
    public MvpPresenter createPresenter() {
        //userPresenter = new UserPresenter(RepositoryFactory.getDataRepository());
        return userPresenter;
    }

    private void initDagger(){
        AppComponent appComponent = ((MyAppliction)getApplication()).getAppComponent();
        DaggerMainComponent.builder()
                .activityModule(new ActivityModule(this))
                 .mainModule(new MainModule(this))
                .appComponent(appComponent)
                 .build().inject(this);
    }

    @Override
    public void initView() {
        progress = new SVProgressHUD(MainActivity.this, Gravity.CENTER, false);
        test.setOnClickListener(new View.OnClickListener() {
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
                }, R.string.rationale_camera);

            }
        });

        test_rxbus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ActivityUtils.from(MainActivity.this)
                        .gotoTargetActivity(Main2Activity.class)
                        .go();
            }
        });
        encode_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.from(MainActivity.this)
                        .gotoTargetActivity(EnCodeActivity.class)
                        .go();
            }
        });
        chooseImgBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] perms = {PermissionUtils.STORAGE};
                needPermssionTask(PermissionUtils.getPermissions(perms), new RequestPermssionCallBack() {
                    @Override
                    public void permissionsGranted() {
                        FileSelectUtils.selectPhoto(filePaths, 3, MainActivity.this);
                    }

                    @Override
                    public void permissionsDenied() {
                        toastShow("授权失败,do something");
                    }
                }, R.string.rationale_camera);

            }
        });
        chooseDocBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String[] perms = {PermissionUtils.STORAGE};
                needPermssionTask(PermissionUtils.getPermissions(perms), new RequestPermssionCallBack() {
                    @Override
                    public void permissionsGranted() {
                        FileSelectUtils.selectDocument(filePaths, 3, MainActivity.this);
                    }

                    @Override
                    public void permissionsDenied() {
                        toastShow("授权失败,do something");
                    }
                }, R.string.rationale_camera);
            }
        });

        tvRv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtils.from(MainActivity.this)
                        .gotoTargetActivity(Main4Activity.class)
                        .go();
            }
        });
    }

    @Override
    public void initData() {
        userPresenter.loadUserInfo();
    }

    @Override
    public void setViewListener() {

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
        if (data instanceof UserInfo) {
            final UserInfo userInfo = (UserInfo) data;
            MLog.e(userInfo.toString());
            name.setText(userInfo.userName);
            age.setText(userInfo.userBirthday);
            userIcon.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    ActivityUtils.from(MainActivity.this)
                            .gotoTargetActivity(FullImageActivity.class)
                            .putExtra("position", "1")
                            .putExtra("picUrl", userInfo.userIco)
                            .go();
                }
            });
            ImageLoader.load(MainActivity.this, userInfo.userIco, userIcon, R.mipmap.ic_launcher);
            phone.setText(userInfo.userPhone);

        }
    }

    @Override
    public void showError(String e) {
        MLog.e(e);
    }

    public void subEvent() {
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
                        MLog.e(e.getMessage());
                        subEvent();
                    }
                });
        RxSubscriptions.add(mRxSub);
    }

    public void subEventSticky() {
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


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FilePickerConst.REQUEST_CODE:
                if (resultCode == RESULT_OK && data != null) {
                    filePaths = data.getStringArrayListExtra(FilePickerConst.KEY_SELECTED_PHOTOS);
                    //use them anywhere
                    MLog.d(filePaths.size());
                }
        }
    }
}
