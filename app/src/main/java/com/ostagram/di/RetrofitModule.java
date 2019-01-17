package com.ostagram.di;

import com.ostagram.webservice.WebserviceCaller;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RetrofitModule {


    @Provides
    @Singleton
    WebserviceCaller getWebservice(){
        return new WebserviceCaller();
    }
}
