package com.ostagram.di;

import com.ostagram.webservice.WebserviceCaller;

import javax.inject.Singleton;

import dagger.Component;
@Singleton
@Component(modules = {UserModule.class,RetrofitModule.class})
public interface UserComponent {

    UserContact getUserContact();

    WebserviceCaller getWebservice();

}
