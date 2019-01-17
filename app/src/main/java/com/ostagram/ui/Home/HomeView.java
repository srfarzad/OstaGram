package com.ostagram.ui.Home;

import com.ostagram.models.Posts;

import java.util.List;

public interface HomeView {

    void showProgress();
    void hideProgress();
    void errorServer();
    void showStories();
    void showPosts(List<Posts> posts);

}
