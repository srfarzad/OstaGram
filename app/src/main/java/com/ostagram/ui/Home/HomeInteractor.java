package com.ostagram.ui.Home;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.ostagram.adapter.PostsAdapter;
import com.ostagram.models.IMessageListener;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

public class HomeInteractor {

    WebserviceCaller webserviceCaller;

    public interface onHomeFinishedListener {
        public void onSuccess(String response);
        public void onError();
    }

    public void getStories() {

    }

    public void getPosts() {
        webserviceCaller = new WebserviceCaller();

        webserviceCaller.getPosts(0, 10, new IMessageListener() {
            @Override
            public void onSuccessObject(Object response) {

            }

            @Override
            public void onSuccess(List response) {

                /*
                PostsAdapter postsAdapter = new PostsAdapter(getApplicationContext(),response);
                recycer_posts.setAdapter(postsAdapter);

                recycer_posts.setLayoutManager(new LinearLayoutManager(getApplicationContext(),
                        LinearLayoutManager.VERTICAL,false));
                */

            }

            @Override
            public void onError(String errorMessage) {
                Log.e("","");
            }
        });
    }

}
