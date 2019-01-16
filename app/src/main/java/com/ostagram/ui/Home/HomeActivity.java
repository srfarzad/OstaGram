package com.ostagram.ui.Home;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.ostaframework.ui.BaseActivity;
import com.ostagram.R;
import com.ostagram.webservice.WebserviceCaller;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import co.ronash.pushe.Pushe;

public class HomeActivity extends BaseActivity implements HomeView {

    WebserviceCaller webserviceCaller;
    HomePresenter homePresenter;

    @BindView(R.id.progress_bar)
    RelativeLayout progress_bar;

    @BindView(R.id.recycer_posts)
    RecyclerView recycer_posts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ButterKnife.bind(this);
        webserviceCaller = new WebserviceCaller();
        Pushe.initialize(this,true);

        homePresenter = new HomePresenter(this, new HomeInteractor());
    }

    @Override
    public int setContentView() {
        return R.layout.activity_main;
    }

    @Override
    public void showProgress() {
        progress_bar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progress_bar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void errorServer() {
        Toast.makeText(getApplicationContext(), R.string.error_server, Toast.LENGTH_LONG);
    }

    @Override
    public void showStories() {

    }

    @Override
    public void shoePosts() {

    }
}
