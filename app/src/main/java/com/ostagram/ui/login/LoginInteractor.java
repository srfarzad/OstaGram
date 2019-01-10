package com.ostagram.ui.login;

import android.text.TextUtils;

import com.ostagram.models.IMessageListener;
import com.ostagram.models.User;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

public class LoginInteractor {

    WebserviceCaller webserviceCaller;


    public interface OnLoginFinishedListener {

        public void onSuccess(String response);

        public void onErrorData(String errorName);

        public void onErrorUsername();

        public void onErrorPassword();


    }


    public void login(String username, String password, OnLoginFinishedListener onLoginFinishedListener) {

        webserviceCaller = new WebserviceCaller();


        if (TextUtils.isEmpty(username)) {
            onLoginFinishedListener.onErrorUsername();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            onLoginFinishedListener.onErrorPassword();
            return;
        }


        webserviceCaller.login(username, password, new IMessageListener() {
            @Override
            public void onSuccessObject(Object response) {
                onLoginFinishedListener.onSuccess(response.toString());
            }

            @Override
            public void onSuccess(List response) {

            }

            @Override
            public void onError(String errorMessage) {
                onLoginFinishedListener.onErrorData(errorMessage+"");
            }
        });


    }


}
