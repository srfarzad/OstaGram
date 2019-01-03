package com.ostagram.service;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.annotation.Nullable;
import android.util.Log;

import com.ostagram.OstaGramService;
import com.ostagram.RequestCallBack;


public class OstaService extends Service {





    @Override
    public IBinder onBind(Intent intent) {
        return binder;
    }


    public final com.ostagram.OstaGramService.Stub binder = new com.ostagram.OstaGramService.Stub() {
        @Override
        public void newService() throws RemoteException {
            Log.e("","");
        }

        @Override
        public void accept(RequestCallBack request) throws RemoteException {
            Log.e("","");
        }
    } ;

}
