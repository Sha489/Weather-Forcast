package com.codegama.weatherforcast.data;

import android.content.Context;


import com.codegama.weatherforcast.data.api.ApiManager;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.data.db.DbManager;
import com.codegama.weatherforcast.data.pref.PrefManager;
import com.codegama.weatherforcast.di.annotation.ApplicationContext;

import org.json.JSONObject;

import io.reactivex.Observable;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbManager mDbManager;
    private final PrefManager mPrefManager;
    private final ApiManager mApiManager;

    public AppDataManager(@ApplicationContext Context context, DbManager dbManager, ApiManager apiManager, PrefManager prefManager) {
        this.mContext = context;
        this.mDbManager = dbManager;
        this.mPrefManager = prefManager;
        this.mApiManager = apiManager;
    }

    @Override
    public String getProfileName() {
        return mPrefManager.getProfileName();
    }

    @Override
    public String getProfileEmail() {
        return mPrefManager.getProfileEmail();
    }

    @Override
    public String getProfilePic() {
        return mPrefManager.getProfilePic();
    }

    @Override
    public String getName() {
        return mPrefManager.getProfilePic();
    }


    @Override
    public Observable<CurrentWeather> getCurrentWeather(String endPoint) {
        return mApiManager.getCurrentWeather(endPoint);
    }
}
