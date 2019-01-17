package com.ostagram.ui.Home;

import java.util.List;

public class HomePresenter implements HomeInteractor.onHomeFinishedListener {

    HomeView view;
    HomeInteractor interactor;

    public HomePresenter (HomeView homeView, HomeInteractor homeInteractor){
        this.view = homeView;
        this.interactor = homeInteractor;
    }




    @Override
    public void onSuccessObject(Object response) {
        if (view != null) {
            view.hideProgress();
            view.showStories();

        }
    }

    @Override
    public void onSuccess(List response) {
        if (view != null) {
            view.hideProgress();
            view.showStories();
            view.showPosts(response);
        }
    }

    @Override
    public void onError(String errorMessage) {
        if (view != null) {
            view.hideProgress();
            view.errorServer();
        }
    }
}
