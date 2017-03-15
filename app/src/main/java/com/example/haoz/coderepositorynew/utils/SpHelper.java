package com.example.haoz.coderepositorynew.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Haoz on 2017/3/15 0015.
 */

public class SpHelper {

    private static final String SP_NAME = "sp_name";
    private static SpHelper spHelper;
    private Context mAppContext;
    private SharedPreferences mSharedPreferences;
    private String info;

    private SpHelper(Context context){
        mAppContext = context.getApplicationContext();
    }

    public static SpHelper getInstance(Context context){
        if(spHelper == null){
            synchronized (SpHelper.class){
                if(spHelper == null){
                    spHelper = new SpHelper(context);
                }
            }
        }
        return spHelper;
    }

    private SharedPreferences getSharedPreferences(){
        if(mSharedPreferences == null){
            mSharedPreferences = mAppContext.getSharedPreferences(SP_NAME, Context.MODE_APPEND);
        }
        return mSharedPreferences;
    }

    public void setInfo(String info){
        this.info = info;
        getSharedPreferences().edit().putString("info", info).apply();
    }

    public String getInfo(){
        if(info.equals("") || info.length() == 0){
            info = getSharedPreferences().getString("info", "");
        }
        return info;
    }

}






















