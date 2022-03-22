package com.codegama.weatherforcast.data.api;


import com.codegama.weatherforcast.data.api.model.CurrentWeather;

import org.json.JSONObject;

import javax.inject.Inject;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Call;

public class AppApiManager implements ApiManager {

    private final ApiManager apiManager;

    @Inject
    public AppApiManager(ApiManager apiManager) {
        this.apiManager = apiManager;
    }


    @Override
    public Observable<CurrentWeather> getCurrentWeather(String endPoint) {
        return apiManager.getCurrentWeather(endPoint);
    }
}
