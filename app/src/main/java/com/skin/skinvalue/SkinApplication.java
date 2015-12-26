package com.skin.skinvalue;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by wyq on 2015/12/26.
 */
public class SkinApplication extends Application {

    private static SharedPreferences mSpSetting;

    @Override
    public void onCreate() {
        super.onCreate();

        initSharedPreferences(getApplicationContext());
    }


    //初始化SharePreference
    public static void initSharedPreferences(Context context) {
        mSpSetting = PreferenceManager.getDefaultSharedPreferences(context);
    }

    //初次打开
    public static void setisFirst(boolean is){
        SharedPreferences.Editor editor = mSpSetting.edit();
        editor.putBoolean("ISFIRST",is).commit();
    }

    //判断是不是第一次打开
    public static boolean isFirst(){
        return mSpSetting.getBoolean("ISFIRST", true);
    }
}
