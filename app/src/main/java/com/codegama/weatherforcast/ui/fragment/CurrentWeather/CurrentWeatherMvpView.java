package com.codegama.weatherforcast.ui.fragment.CurrentWeather;


import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.base.MvpView;

import org.json.JSONObject;

import okhttp3.ResponseBody;

public interface CurrentWeatherMvpView extends MvpView {

    public void getCurrentWeatherResponse(CurrentWeather currentWeather);

}
