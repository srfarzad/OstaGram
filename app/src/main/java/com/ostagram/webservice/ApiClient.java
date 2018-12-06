package com.ostagram.webservice;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    public static Retrofit retrofit = null;

    public static String BaseURL= "http://androidsupport.ir/picpic/";


    public static Retrofit getClient(){

        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BaseURL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }

        return  retrofit;

    }


}
