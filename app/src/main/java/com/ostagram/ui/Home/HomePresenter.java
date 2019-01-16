package com.ostagram.ui.Home;

public class HomePresenter implements HomeInteractor.onHomeFinishedListener {

    HomeView view;
    HomeInteractor interactor;

    public HomePresenter (HomeView homeView, HomeInteractor homeInteractor){
        this.view = homeView;
        this.interactor = homeInteractor;
    }


    @Override
    public void onSuccess(String response) {
        if (view != null) {
            view.hideProgress();
            view.showStories();
            view.shoePosts();
        }
    }

    @Override
    public void onError() {
        if (view != null) {
            view.hideProgress();
            view.errorServer();
        }
    }


}
