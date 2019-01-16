package com.ostagram.ui.Main;

import com.ostagram.models.IMessageListener;
import com.ostagram.models.Posts;

import java.util.List;

public class MainPresenter implements MainInteractor.OnGetDataFinishedListener  {

MainView mainView;
MainInteractor mainInteractor;

    public MainPresenter(MainView mainView, MainInteractor mainInteractor) {
        this.mainView = mainView;
        this.mainInteractor = mainInteractor;
    }

    @Override
    public void onSuccess(List<Posts> list) {
        if(mainView!=null) {
            mainView.setItem(list);
        }
    }

    @Override
    public void onErrorData(String errorName) {

        if(mainView!=null) {
            mainView.errorServer(errorName);
        }
    }
}




