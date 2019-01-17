package com.ostagram.ui.Home;

import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.ostagram.adapter.PostsAdapter;
import com.ostagram.models.IMessageListener;
import com.ostagram.webservice.WebserviceCaller;

import java.util.List;

public class HomeInteractor {

    WebserviceCaller webserviceCaller;

    public interface onHomeFinishedListener<T> {
        public void onSuccessObject(T response);

        public void onSuccess(List<T> response);

        public void onError(String errorMessage);
    }

    public void getStories() {

    }

    public void getPosts(int from , int to , onHomeFinishedListener onHomeFinishedListener) {
        webserviceCaller = new WebserviceCaller();

        webserviceCaller.getPosts(from, to, new IMessageListener() {
            @Override
            public void onSuccessObject(Object response) {
                onHomeFinishedListener.onSuccessObject(response);
            }

            @Override
            public void onSuccess(List response) {

                onHomeFinishedListener.onSuccess(response);
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
                onHomeFinishedListener.onError(errorMessage.toString()+"");
            }
        });
    }

}
