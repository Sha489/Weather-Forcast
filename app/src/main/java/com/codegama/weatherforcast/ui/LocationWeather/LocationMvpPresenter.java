package com.codegama.weatherforcast.ui.LocationWeather;


import com.codegama.weatherforcast.ui.base.MvpPresenter;
import com.codegama.weatherforcast.ui.base.MvpView;

public interface LocationMvpPresenter<V extends MvpView> extends MvpPresenter<V> {

    public void getCurrentWeatherFromAPI(String endpoint);

}
