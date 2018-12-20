package com.ostagram.config;

import android.content.Context;
import android.content.SharedPreferences;

public class AppSetting {

    SharedPreferences sharedPreferences;

    SharedPreferences.Editor editor;
    public AppSetting(Context context) {

        sharedPreferences = context.getSharedPreferences("AppSetting", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }


    public void setUserId(int code){
        editor.putInt("Code", code);
        editor.commit();
    }

    public int getUserId(){
        return sharedPreferences.getInt("Code",0);
    }





}
