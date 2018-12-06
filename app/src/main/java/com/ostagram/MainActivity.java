package com.ostagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.ostagram.models.IMessageListener;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

public class MainActivity extends AppCompatActivity {


    WebserviceCaller webserviceCaller;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webserviceCaller = new WebserviceCaller();


        webserviceCaller.getPosts(1, 10, new IMessageListener() {
            @Override
            public void onSuccess(List response) {
                Log.e("","");
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("","");
            }
        });


    }
}
