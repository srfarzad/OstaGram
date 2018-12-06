package com.ostagram.webservice;


import com.ostagram.models.IMessageListener;
import com.ostagram.models.Posts;

import java.util.List;

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



}
