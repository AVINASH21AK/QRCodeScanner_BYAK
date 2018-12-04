package com.qrcodescanner.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;

import com.orhanobut.hawk.Hawk;
import com.qrcodescanner.R;
import com.qrcodescanner.utils.App;
import com.qrcodescanner.utils.Constants;


public class ActSplash extends BaseActivity {

    String TAG = "ActSplash";
    int TIME = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            ViewGroup.inflate(this, R.layout.act_splash, ll_SubMainContainer);



            initialize();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }





    public void initialize() {
        try {

             /*----- BaseActivity -----*/
            setEnableDrawer(false);
            rl_baseToolbar.setVisibility(View.GONE);


            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {

                    Intent i1 = new Intent(ActSplash.this, ActScanQr.class);
                    App.myStartActivityRefersh(ActSplash.this, i1);


                }
            }, TIME);







        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
