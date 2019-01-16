package com.ostagram.ui.Main;

import com.ostagram.models.IMessageListener;
import com.ostagram.models.Posts;
import com.ostagram.ui.login.LoginInteractor;
import com.ostagram.webservice.ApiInterface;
import com.ostagram.webservice.WebserviceCaller;

import java.util.Arrays;
import java.util.List;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;


import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor {
    WebserviceCaller webserviceCaller;
    public interface OnGetDataFinishedListener {

        public void onSuccess(List<Posts> list);

        public void onErrorData(String errorName);

    }
    public void setList(int from, int to, MainInteractor.OnGetDataFinishedListener onFinishedListener) {

        webserviceCaller = new WebserviceCaller();
        webserviceCaller.getPosts(0, 10, new IMessageListener() {
            @Override
            public void onSuccessObject(Object response) {

            }

            @Override
            public void onSuccess(List response) {

                onFinishedListener.onSuccess(response);
            }

            @Override
            public void onError(String errorMessage) {
                onFinishedListener.onErrorData("error");

            }
        });

    }



}













