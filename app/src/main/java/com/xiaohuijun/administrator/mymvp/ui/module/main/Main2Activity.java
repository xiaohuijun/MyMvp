package com.xiaohuijun.administrator.mymvp.ui.module.main;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.RxBus.RxBus;
import com.xiaohuijun.administrator.mymvp.ui.BaseActivity;

import butterknife.BindView;

public class Main2Activity extends BaseActivity implements View.OnClickListener{
    @BindView(R.id.event_text)
    TextView event_text;
    @BindView(R.id.event_sticky_text)
    TextView event_sticky_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public void onClick(View view) {
       if(view.getId() == R.id.event_text){
           Bundle bundle = new Bundle();
           bundle.putString("event","event");
           RxBus.getDefault().post(bundle);
       }else if(view.getId() == R.id.event_sticky_text){
           Bundle bundle = new Bundle();
           bundle.putString("event_sticky","event_sticky");
           RxBus.getDefault().postSticky(bundle);
       }
    }
}
