package com.ostagram.ui.login;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.ostaframework.ui.BaseActivity;
import com.ostagram.MainActivity;
import com.ostagram.R;
import com.ostagram.config.AppSetting;
import com.ostagram.webservice.DataParser;
import com.ostagram.webservice.WebserviceCaller;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.input_mobile_phone)
    AppCompatEditText input_mobile_phone;
    @BindView(R.id.input_password)
    AppCompatEditText input_password;
    @BindView(R.id.btn_signin)
    Button btn_signin;
    @BindView(R.id.link_create)
    TextView link_create;

    @BindView(R.id.progress_bar)
    LottieAnimationView progress_bar;

    @BindView(R.id.rel_main)
    RelativeLayout rel_main;

    WebserviceCaller webserviceCaller;
    AppSetting appSetting;

    @BindString(R.string.fill_username)
    String fill_username;
    @BindString(R.string.fill_password)
    String fill_password;
    @BindString(R.string.login_error)
    String login_error;

    LoginPresentor loginPresentor;


    @Override
    public int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        appSetting = new AppSetting(getApplicationContext());

        loginPresentor = new LoginPresentor(this, new LoginInteractor());


    }

    @OnClick(R.id.btn_signin)
    public void btn_signin_click() {

        String username = input_mobile_phone.getText().toString();
        String password = input_password.getText().toString();

        loginPresentor.validateLogin(username, password);


    }

    @Override
    public void showProgress() {
        progress_bar.setVisibility(View.VISIBLE);
        progress_bar.setRepeatCount(LottieDrawable.INFINITE);
        progress_bar.playAnimation();
        progress_bar.setSpeed(1);
    }

    @Override
    public void hideProgress() {
        progress_bar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setUsernameError() {
        input_mobile_phone.setError(fill_username);
    }

    @Override
    public void setPasswordError() {
        input_mobile_phone.setError(fill_password);
    }

    @Override
    public void navigateToHome(String response) {
        String userCode = null;
        try {
            userCode = DataParser.parseUser(response.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        appSetting.setUserId(Integer.parseInt(userCode));

        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void errorServer(String serverError) {
        Snackbar.make(rel_main, login_error, Snackbar.LENGTH_LONG).show();

    }

}
