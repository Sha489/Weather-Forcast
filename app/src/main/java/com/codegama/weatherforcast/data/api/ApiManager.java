package com.codegama.weatherforcast.data.api;


import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.util.AppConstants;

import org.json.JSONObject;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface ApiManager {

    @GET
    Observable<CurrentWeather> getCurrentWeather(@Url String endPoint);

}
