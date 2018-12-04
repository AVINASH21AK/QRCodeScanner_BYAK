package com.qrcodescanner.utils;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.multidex.MultiDex;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;

import com.orhanobut.hawk.Hawk;
import com.qrcodescanner.R;

import java.io.File;
import java.util.regex.Pattern;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by avinash.kahar on 3/20/2018.
 */

public class App extends Application {

    public static String TAG = "APP";
    static Context context;
    private static App mInstance;
    public static String App_mode = Constants.APP_MODE.Development;  //1 for Production and 2 for Development
    public static String App_plateform = "2";  //1 for IOS and 2 for Android
    public static String strFolderName = "QRCodeScanner";
    public static String strSDarPath = Environment.getExternalStorageDirectory().toString();
    public static String strFolderFullPath = App.strSDarPath + File.separator + App.strFolderName;

    static Typeface tf_Regular, tf_SemiBold, tf_Bold;

    //-- Flag - Thing used for Single App Run
    public static boolean showAppUpdater = true;


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(newBase);
        MultiDex.install(this);
    }


    @Override
    public void onCreate() {
        super.onCreate();

        MultiDex.install(this);
        context = getApplicationContext();
        mInstance = this;

        setRegularFontsAllTxt();

        //-- SharedPreference
        Hawk.init(context).build();


    }


    public void setRegularFontsAllTxt(){
        try{

            CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/GOTHAMHTF-REGULAR.OTF")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            );

        }catch (Exception e){
            e.printStackTrace();
        }
    }



    //-- Hide Keyboard
    public static void hideSoftKeyboardMy(Activity activity, View view) {
        try {
            InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
            //inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //-- Log
    public static void showLog(String ActivityName, String strMessage) {
        Log.d("From: ", ActivityName + " -- " + strMessage);
    }


    //-- Snackbar
    public static void showSnackBar(View view, String strMessage) {
        // Toast.makeText(context, ""+strMessage, Toast.LENGTH_SHORT).show();

        try {
            Snackbar snackbar = Snackbar.make(view, strMessage, Snackbar.LENGTH_LONG);
            View snackbarView = snackbar.getView();
            snackbarView.setBackgroundColor(Color.BLACK);
            TextView textView = (TextView) snackbarView.findViewById(android.support.design.R.id.snackbar_text);
            textView.setTextColor(Color.WHITE);
            snackbar.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void myStartActivityRefersh(Activity activity, Intent intent) {
        activity.finish();
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    //-- Valid email
    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile("[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,3}");
        // Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();
    }

    //-- Valid string
    public static boolean isValidString(String str){

        if(str != null && str.trim().length()>0)
            return true;
        else
            return false;

    }
}
