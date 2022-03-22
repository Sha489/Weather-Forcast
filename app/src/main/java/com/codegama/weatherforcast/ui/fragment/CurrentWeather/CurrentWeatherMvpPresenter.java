package com.codegama.weatherforcast.ui.fragment.CurrentWeather;


import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.base.MvpPresenter;
import com.codegama.weatherforcast.ui.base.MvpView;

import javax.inject.Inject;

public interface CurrentWeatherMvpPresenter<V extends MvpView> extends MvpPresenter<V> {

    // response changes
    public void getCurrentWeatherFromAPI(String endpoint);

}
