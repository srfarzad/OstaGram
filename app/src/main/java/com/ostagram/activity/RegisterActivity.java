package com.ostagram.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ostagram.MainActivity;
import com.ostagram.R;
import com.ostagram.config.AppSetting;
import com.ostagram.models.IMessageListener;
import com.ostagram.models.UserData;
import com.ostagram.webservice.DataParser;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.realm.Realm;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.txtUsername)
    EditText txtUsername;

    @BindView(R.id.txtPassword)
    EditText txtPassword;

    WebserviceCaller webserviceCaller;

    @BindView(R.id.btn_login)Button btn_login;

    AppSetting appSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        Realm.init(getApplicationContext());


        webserviceCaller = new WebserviceCaller();
        appSetting = new AppSetting(getApplicationContext());

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String username = txtUsername.getText().toString();
                final String password = txtPassword.getText().toString();


                webserviceCaller.Register(username, password, new IMessageListener() {
                    @Override
                    public void onSuccessObject(Object response) {
                        String res1 = "MASOUD";



                    }

                    @Override
                    public void onSuccess(List response) {
                        String res2 = "MAHDI";
                    }

                    @Override
                    public void onError(String errorMessage) {
                        String res3 = "MOHAMMAD";
                    }
                });

            }
        });


    }


    @OnClick(R.id.btn_login)
    public void loginClick(){



        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        webserviceCaller.login(username, password, new IMessageListener() {
            @Override
            public void onSuccessObject(Object response) {
                Log.e("","");

                try {
                    String userCode = DataParser.parseUser(response.toString());
                    appSetting.setUserId(Integer.parseInt(userCode));

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    UserData userData = new UserData();

                    userData.setPassword(password);
                    userData.setUsername(username);


                    Realm realm = Realm.getDefaultInstance();

                    realm.beginTransaction();
                    realm.copyToRealm(userData);

                    realm.commitTransaction();


                    Log.e("","");




                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onSuccess(List response) {
                Log.e("","");
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("","");
            }
        });


    }


}
