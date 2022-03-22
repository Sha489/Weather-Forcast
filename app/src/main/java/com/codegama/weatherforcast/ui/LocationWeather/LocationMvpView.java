package com.codegama.weatherforcast.ui.LocationWeather;


import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.base.MvpView;

public interface LocationMvpView extends MvpView {

    public void getCurrentWeatherResponse(CurrentWeather currentWeather);

}
