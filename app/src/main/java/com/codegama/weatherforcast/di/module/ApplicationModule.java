package com.codegama.weatherforcast.di.module;

import android.content.Context;

import com.codegama.weatherforcast.WeatherApp;
import com.codegama.weatherforcast.data.AppDataManager;
import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.data.api.ApiManager;
import com.codegama.weatherforcast.data.db.AppDbManager;
import com.codegama.weatherforcast.data.db.DbManager;
import com.codegama.weatherforcast.data.pref.AppPrefManager;
import com.codegama.weatherforcast.data.pref.PrefManager;
import com.codegama.weatherforcast.di.annotation.ApplicationContext;
import com.codegama.weatherforcast.di.annotation.PreferenceInfo;
import com.codegama.weatherforcast.util.AppConstants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module(includes = NetworkModule.class)
public class ApplicationModule {

    private final WeatherApp mApplication;

    public ApplicationModule(WeatherApp mApplication) {
        this.mApplication = mApplication;
    }

    @Provides
    @ApplicationContext
    Context provideAppContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    DataManager providesDataManager(@ApplicationContext Context context, DbManager dbManager,
                                    ApiManager apiManager, PrefManager prefManager) {
        return new AppDataManager(context, dbManager, apiManager, prefManager);
    }

    @Provides
    @Singleton
    ApiManager providesApiManager(Retrofit retrofit) {
        return retrofit.create(ApiManager.class);
    }

    @Provides
    @Singleton
    DbManager providesDbManager(AppDbManager appDbManager) {
        return appDbManager;
    }

    @Provides
    @Singleton
    PrefManager providesPrefManager(AppPrefManager appPrefManager) {
        return appPrefManager;
    }

    @Provides
    @PreferenceInfo
    String providePrefName(){
        return AppConstants.PREF_NAME;
    }
}
