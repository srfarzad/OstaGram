package com.ostagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.ostagram.adapter.PostsAdapter;
import com.ostagram.di.DaggerUserComponent;
import com.ostagram.di.RetrofitModule;
import com.ostagram.di.UserComponent;
import com.ostagram.di.UserContact;
import com.ostagram.di.UserModule;
import com.ostagram.models.IMessageListener;
import com.ostagram.models.User;
import com.ostagram.service.PlayService;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ronash.pushe.Pushe;

public class MainActivity extends AppCompatActivity {


    WebserviceCaller webserviceCaller;

    @BindView(R.id.recycer_posts)
    RecyclerView recycer_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        webserviceCaller = new WebserviceCaller();
        Pushe.initialize(this,true);



        startService(new Intent(getApplicationContext(), PlayService.class));


        webserviceCaller.getPosts(0, 10, new IMessageListener() {
            @Override
            public void onSuccessObject(Object response) {

            }

            @Override
            public void onSuccess(List response) {
                PostsAdapter postsAdapter = new PostsAdapter(getApplicationContext(),response);
                recycer_posts.setAdapter(postsAdapter);

                recycer_posts.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL,false));
            }

            @Override
            public void onError(String errorMessage) {
                Log.e("","");
            }
        });


        Intent intent = new Intent();
        intent.setClassName("com.ostagramsecond", "com.ostagramsecond.Reciver");
        intent.setAction("com.ostagramsecond.Reciver");
        intent.putExtra("Id",1);
        intent.putExtra("Data","{id:5}");
        sendBroadcast(intent);


        UserComponent component = DaggerUserComponent.builder()
                .userModule(new UserModule()).build();


        component.getUserContact().setUserEmail("Ali");

        Toast.makeText(getApplicationContext(),component.getUserContact().getUserEmail(),
                Toast.LENGTH_LONG).show();


        UserComponent component1 = DaggerUserComponent.builder().
                retrofitModule(new RetrofitModule()).build();

        //component.getWebservice().login();


    }
}
