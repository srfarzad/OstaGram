package com.ostagram.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class BootableApp extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        Toast.makeText(context, "OStaGram Service", Toast.LENGTH_LONG).show();
        Log.e("OStaGram Service","OStaGram Service");
    }
}
