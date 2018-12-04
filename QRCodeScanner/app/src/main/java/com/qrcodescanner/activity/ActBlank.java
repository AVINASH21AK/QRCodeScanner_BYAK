package com.qrcodescanner.activity;

import android.os.Bundle;
import android.view.ViewGroup;

import com.qrcodescanner.R;
import com.qrcodescanner.utils.App;


public class ActBlank extends BaseActivity {

    String TAG = "ActBlank";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            ViewGroup.inflate(this, R.layout.act_blank, ll_SubMainContainer);

            initialize();
            clickEvent();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void initialize() {
        try {

             /*----- BaseActivity -----*/
            setEnableDrawer(false);
            //rl_baseToolbar.setVisibility(View.GONE);


            /*----- This Activity -----*/





             /*------- Fonts --------*/


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clickEvent() {
        try {


        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();

    }


}
