package com.codegama.weatherforcast.ui.activity.HomeActivity;


import com.codegama.weatherforcast.ui.base.MvpPresenter;
import com.codegama.weatherforcast.ui.base.MvpView;

public interface HomeMvpPresenter<V extends MvpView> extends MvpPresenter<V> {

    void onNotificationClicked();
}
