package com.qrcodescanner.activity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qrcodescanner.R;
import com.qrcodescanner.utils.App;
import com.google.zxing.Result;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class ActScanQr extends BaseActivity  implements ZXingScannerView.ResultHandler {

    String TAG = "ActScanQr";
    @BindView(R.id.tvQRResult) TextView tvQRResult;
    @BindView(R.id.rlRefresh) RelativeLayout rlRefresh;

    private ZXingScannerView mScannerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            setContentView(R.layout.act_scanqr);
            //ViewGroup.inflate(this, R.layout.act_scanqr, ll_SubMainContainer);
            ButterKnife.bind(this);

            ViewGroup contentFrame = (ViewGroup) findViewById(R.id.content_frame);
            mScannerView = new ZXingScannerView(this);
            contentFrame.addView(mScannerView);


            initialize();
            clickEvent();
            get_InstallApp_WithPermission();

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    public void get_InstallApp_WithPermission() {
        try {

            StringBuffer appNameAndPermissions = new StringBuffer();
            PackageManager pm = getPackageManager();
            List<android.content.pm.ApplicationInfo> packages = pm.getInstalledApplications(PackageManager.GET_META_DATA);

            for (android.content.pm.ApplicationInfo applicationInfo : packages) {
                App.showLog(TAG, "-----> App: " + applicationInfo.name + " Package: " + applicationInfo.packageName);
                try {
                    PackageInfo packageInfo = pm.getPackageInfo(applicationInfo.packageName, PackageManager.GET_PERMISSIONS);
                    appNameAndPermissions.append(packageInfo.packageName + "*******:\n");

                    //Get Permissions
                    String[] requestedPermissions = packageInfo.requestedPermissions;
                    if (requestedPermissions != null) {
                        for (int i = 0; i < requestedPermissions.length; i++) {
                            App.showLog(TAG, requestedPermissions[i]);
                            appNameAndPermissions.append(requestedPermissions[i] + "\n");
                        }
                        appNameAndPermissions.append("\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        try {

             /*----- BaseActivity -----*/
            setEnableDrawer(false);
            rl_baseToolbar.setVisibility(View.GONE);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickEvent() {
        try {

            rlRefresh.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvQRResult.setText("");
                    rlRefresh.setVisibility(View.GONE);

                    // If you would like to resume scanning, call this method below:
                    mScannerView.resumeCameraPreview(ActScanQr.this);
                }
            });

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    protected void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this); // Register ourselves as a handler for scan results.
        mScannerView.startCamera();          // Start camera on resume
    }

    @Override
    protected void onPause() {
        super.onPause();
        mScannerView.stopCamera();           // Stop camera on pause
    }


    @Override
    public void handleResult(Result rawResult) {
        // Do something with the result here
        App.showLog(TAG, rawResult.getText()); // Prints scan results
        App.showLog(TAG, rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        tvQRResult.setText(""+rawResult.getText());
        rlRefresh.setVisibility(View.VISIBLE);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


}
