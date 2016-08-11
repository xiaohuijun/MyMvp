package com.xiaohuijun.administrator.mymvp.ui.module.common.EnCode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.google.zxing.Result;
import com.google.zxing.client.result.ParsedResult;
import com.mylhyl.zxing.scanner.OnScannerCompletionListener;
import com.mylhyl.zxing.scanner.ScannerView;
import com.xiaohuijun.administrator.mymvp.R;
import com.xiaohuijun.administrator.mymvp.common.util.MLog;

import butterknife.BindView;

public class EnCodeActivity extends AppCompatActivity implements OnScannerCompletionListener {
    @BindView(R.id.scannerView)
    ScannerView scannerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_en_code);
        EnCodeUtil.initScannerView(scannerView);
    }

    @Override
    protected void onResume() {
        scannerView.onResume();
        super.onResume();

    }

    @Override
    protected void onPause() {
        scannerView.onPause();
        super.onPause();
    }


    @Override
    public void OnScannerCompletion(Result result, ParsedResult parsedResult, Bitmap bitmap) {
        MLog.e(result.toString()+parsedResult.getType());
    }
}
