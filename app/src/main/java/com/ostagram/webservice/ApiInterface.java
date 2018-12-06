package com.ostagram.webservice;

import com.ostagram.models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {



    @POST("myPosts.php")
    @FormUrlEncoded
    Call<List<Posts>>  getAllPosts(@Field("from") int from , @Field("to") int to );

}
