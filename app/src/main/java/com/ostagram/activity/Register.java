package com.ostagram.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ostagram.R;
import com.ostagram.models.IMessageListener;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Register extends AppCompatActivity {

    @BindView(R.id.btnRegister)
    Button btnRegister;

    @BindView(R.id.txtUsername)
    EditText txtUsername;

    @BindView(R.id.txtPassword)
    EditText txtPassword;

    WebserviceCaller webserviceCaller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);



        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String username = txtUsername.getText().toString();
                String password = txtPassword.getText().toString();

                webserviceCaller = new WebserviceCaller();
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
}
