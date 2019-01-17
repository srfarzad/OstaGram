package com.ostagram.di;

import android.util.Log;

public class Contact {

    private String email;


    public Contact() {
        this.email = "Test@gmail.com";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public void deleteEmail() {
        email = null;
    }

    public void print(){
        Log.e("Print", email);
    }

}
