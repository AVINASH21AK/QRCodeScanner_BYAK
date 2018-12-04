package com.qrcodescanner.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qrcodescanner.R;
import com.qrcodescanner.utils.App;
import com.qrcodescanner.utils.Constants;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;


public class BaseActivity extends AppCompatActivity {

    protected String TAG = "BaseActivity";

    protected DrawerLayout drawer;
    protected RelativeLayout left_drawer;
    protected RelativeLayout rl_baseToolbar;
    protected LinearLayout ll_SubMainContainer;
    protected ImageView ivMenu;
    protected TextView tvTitle;



    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_base);

        baseClickInitialize();
        baseClickEvent();
    }

    public void baseClickInitialize(){
        try{
           drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
            left_drawer = (RelativeLayout) findViewById(R.id.left_drawer);
            rl_baseToolbar = (RelativeLayout) findViewById(R.id.rl_baseToolbar);
            ll_SubMainContainer = (LinearLayout) findViewById(R.id.ll_SubMainContainer);
            ivMenu = (ImageView) findViewById(R.id.ivMenu);
            tvTitle = (TextView) findViewById(R.id.tvTitle);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void baseClickEvent(){
        try{
            ivMenu.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (drawer.isDrawerOpen(left_drawer)) {
                        drawer.closeDrawers();
                    } else {
                        drawer.openDrawer(left_drawer);

                    }
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void setEnableDrawer(boolean blnEnable) {
        if (blnEnable == true) {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        } else {
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        }

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(left_drawer)) {
            drawer.closeDrawers();
        } else {
            finish();
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
        }

    }

}
