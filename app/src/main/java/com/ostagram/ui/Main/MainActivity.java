package com.ostagram.ui.Main;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.ostagram.R;
import com.ostagram.adapter.PostsAdapter;
import com.ostagram.models.Posts;
import com.ostagram.service.PlayService;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.ronash.pushe.Pushe;

public  class MainActivity extends AppCompatActivity implements MainView  {
    @BindView(R.id.recycer_posts)
    RecyclerView recycer_posts;
    MainPresenter mainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mainPresenter=new MainPresenter(this,new MainInteractor());

        Pushe.initialize(this,true);



        startService(new Intent(getApplicationContext(), PlayService.class));
    }

    @Override
    public void setItem(List<Posts> list) {
        recycer_posts.setAdapter(new PostsAdapter(this,list));
        recycer_posts.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                LinearLayoutManager.VERTICAL,false));

    }

    @Override
    public void errorServer(String serverError) {
        Toast.makeText(getApplicationContext(),"Server Error",Toast.LENGTH_LONG).show();

    }
}
