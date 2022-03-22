package com.codegama.weatherforcast.di.component;


import com.codegama.weatherforcast.WeatherApp;
import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.data.api.ApiManager;
import com.codegama.weatherforcast.data.db.DbManager;
import com.codegama.weatherforcast.data.pref.PrefManager;
import com.codegama.weatherforcast.di.module.ApplicationModule;
import com.codegama.weatherforcast.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    void inject(WeatherApp weatherApp);

    DataManager dataManager();

    PrefManager prefManager();

    ApiManager apiManager();

    DbManager dbManager();
}
