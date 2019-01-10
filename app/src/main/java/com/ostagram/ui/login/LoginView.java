package com.ostagram.ui.login;

public interface LoginView {


    void showProgress();

    void hideProgress();

    void setUsernameError();

    void setPasswordError();

    void navigateToHome(String response);

    void errorServer(String serverError);
}
