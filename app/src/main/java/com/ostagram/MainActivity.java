package com.ostagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.ostagram.adapter.PostsAdapter;
import com.ostagram.models.IMessageListener;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

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


        webserviceCaller.getPosts(0, 10, new IMessageListener() {
            @Override
            public void onSuccess(List response) {
                Log.e("","");


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


    }
}
