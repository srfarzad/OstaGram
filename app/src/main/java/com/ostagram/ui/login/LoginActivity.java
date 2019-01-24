package com.ostagram.ui.login;

import android.Manifest;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieDrawable;
import com.crashlytics.android.Crashlytics;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.ostaframework.location.GPSTracker;
import com.ostaframework.ui.BaseActivity;
import com.ostagram.MainActivity;
import com.ostagram.R;
import com.ostagram.activity.AdsActivity;
import com.ostagram.config.AppSetting;
import com.ostagram.webservice.DataParser;
import com.ostagram.webservice.WebserviceCaller;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import butterknife.BindString;
import butterknife.BindView;
import butterknife.OnClick;
import io.fabric.sdk.android.Fabric;

public class LoginActivity extends BaseActivity implements LoginView {


    @BindView(R.id.input_mobile_phone)
    AppCompatEditText input_mobile_phone;
    @BindView(R.id.input_password)
    AppCompatEditText input_password;
    @BindView(R.id.btn_signin)
    Button btn_signin;
    @BindView(R.id.link_create)
    TextView link_create;

    @BindView(R.id.btn_ads) AppCompatButton btn_ads;

   /* @BindView(R.id.progress_bar)
    LottieAnimationView progress_bar;*/

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

    FirebaseAuth firebaseAuth;

    AdView mAdView;

    double latitude,longitude;


    @Override
    public int setContentView() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        firebaseAuth = FirebaseAuth.getInstance();

        appSetting = new AppSetting(getApplicationContext());

        loginPresentor = new LoginPresentor(this, new LoginInteractor());
        mAdView = (AdView) findViewById(R.id.adView);


        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                // Check the LogCat to get your test device ID
                .addTestDevice("C04B1BFFB0774708339BC273F8A43708")
                .build();

        loads(adRequest);

        getLocation();

    }


    void getLocation(){

        Dexter.withActivity(this)
                .withPermission(Manifest.permission.ACCESS_COARSE_LOCATION)
                .withListener(new PermissionListener() {
                    @Override
                    public void onPermissionGranted(PermissionGrantedResponse response) {
                        // permission is granted, open the GPS


                        GPSTracker gpsTracker = new GPSTracker(getApplicationContext());


                        if(gpsTracker.canGetLocation()){

                            latitude = gpsTracker.getLatitude();
                            longitude = gpsTracker.getLongitude();

                            Locale locale = new Locale("fa");
                            Geocoder geocoder = new Geocoder(getApplicationContext(),locale);

                            try {
                                List<Address> addressList= geocoder.getFromLocation(latitude,longitude,1);


                                Log.e("","");

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            catch (Exception e) {

                            }





                        }





                    }

                    @Override
                    public void onPermissionDenied(PermissionDeniedResponse response) {
                        // check for permanent denial of permission
                        if (response.isPermanentlyDenied()) {
                            // navigate user to app settings
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                }).check();

    }




    @OnClick(R.id.btn_ads)
    public void btn_ads_click(){

        Intent intent = new Intent(getApplicationContext(),AdsActivity.class);

        startActivity(intent);
    }


    private void loads(AdRequest adRequest) {
        mAdView.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                Toast.makeText(getApplicationContext(), "Ad is closed!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(getApplicationContext(), "Ad failed to load! error code: " + errorCode, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(getApplicationContext(), "Ad left application!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }
        });

        mAdView.loadAd(adRequest);
    }


    @OnClick(R.id.btn_signin)
    public void btn_signin_click() {

        String username = input_mobile_phone.getText().toString();
        String password = input_password.getText().toString();

        loginPresentor.validateLogin(username, password);



       /* firebaseAuth.createUserWithEmailAndPassword(username,password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.e("","");
                    }
                });*/


      /*  firebaseAuth.signInWithEmailAndPassword(username,password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.e("","");
                    }
                });*/

      //  firebaseAuth.getCurrentUser();



    }

    @Override
    public void showProgress() {
      /*  progress_bar.setVisibility(View.VISIBLE);
        progress_bar.setRepeatCount(LottieDrawable.INFINITE);
        progress_bar.playAnimation();
        progress_bar.setSpeed(1);*/
    }

    @Override
    public void hideProgress() {
       // progress_bar.setVisibility(View.INVISIBLE);
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
