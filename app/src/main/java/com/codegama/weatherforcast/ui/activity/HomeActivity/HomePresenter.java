package com.codegama.weatherforcast.ui.activity.HomeActivity;

import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.ui.base.BasePresenter;

import javax.inject.Inject;

public class HomePresenter<V extends HomeMvpView> extends BasePresenter<V>
        implements HomeMvpPresenter<V> {

    private int currentFragmentPos;

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Inject
    HomePresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void onNotificationClicked() {
        getMvpView().openNotificationScreen();
    }

}
