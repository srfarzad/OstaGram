package com.ostagram.webservice;


import com.ostagram.models.IMessageListener;
import com.ostagram.models.Posts;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WebserviceCaller {

    ApiInterface apiInterface;

    public WebserviceCaller(){
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
    }

    public void getPosts(int from , int to , final IMessageListener iMessageListener){

        Call<List<Posts>> getData = apiInterface.getAllPosts(from , to);


        getData.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, Response<List<Posts>> response) {
                iMessageListener.onSuccess(response.body());
            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                iMessageListener.onError(t.getMessage().toString());
            }
        });
    }

    public void Register(String username, String password, final IMessageListener iMessageListener) {
        Call<ResponseBody> getData = apiInterface.register(username, password);
        getData.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                iMessageListener.onSuccessObject(response.body());
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                iMessageListener.onError(t.getMessage().toString());
            }
        });
    }
}
