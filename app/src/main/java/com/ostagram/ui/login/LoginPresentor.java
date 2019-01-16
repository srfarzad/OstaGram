package com.ostagram.ui.login;

public class LoginPresentor implements  LoginInteractor.OnLoginFinishedListener {

    LoginView view;
    LoginInteractor loginInteractor;
   public LoginPresentor (LoginView loginView, LoginInteractor loginInteractor){
       view =  loginView;
       this.loginInteractor = loginInteractor;
   }


   public void validateLogin(String username , String password){

       view.showProgress();
       loginInteractor.login(username ,password , this );

   }

    @Override
    public void onSuccess(String response) {
       if(view!=null) {
            view.hideProgress();
           view.navigateToHome(response);
       }

    }

    @Override
    public void onErrorData(String errorName) {
       if(view!=null) {
           view.hideProgress();
           view.errorServer(errorName);
       }

    }

    @Override
    public void onErrorUsername() {
        if(view!=null) {
            view.hideProgress();
            view.setUsernameError();
        }
    }

    @Override
    public void onErrorPassword() {
        if(view!=null) {
            view.hideProgress();
            view.setPasswordError();
        }
    }
}
