package com.ostagram.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UserModule {


    @Provides
    @Singleton
    Contact getContact() {
        return new Contact();
    }

    @Provides
    @Singleton
    UserContact getUserContact() {
        return new UserContact(new Contact());
    }



}
