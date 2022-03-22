package com.codegama.weatherforcast.di.module;

import android.content.Context;

import androidx.appcompat.app.AppCompatActivity;

import com.codegama.weatherforcast.di.annotation.ActivityContext;
import com.codegama.weatherforcast.di.annotation.PerActivity;
import com.codegama.weatherforcast.ui.LocationWeather.LocationMvpPresenter;
import com.codegama.weatherforcast.ui.LocationWeather.LocationMvpView;
import com.codegama.weatherforcast.ui.LocationWeather.LocationPresenter;
import com.codegama.weatherforcast.ui.activity.HomeActivity.HomeMvpPresenter;
import com.codegama.weatherforcast.ui.activity.HomeActivity.HomeMvpView;
import com.codegama.weatherforcast.ui.activity.HomeActivity.HomePresenter;
import com.codegama.weatherforcast.ui.fragment.CurrentWeather.CurrentWeatherMvpPresenter;
import com.codegama.weatherforcast.ui.fragment.CurrentWeather.CurrentWeatherMvpView;
import com.codegama.weatherforcast.ui.fragment.CurrentWeather.CurrentWeatherPresenter;

import dagger.Module;
import dagger.Provides;


@Module(includes = UiModule.class)
public class ActivityModule {

    private AppCompatActivity mActivity;

    public ActivityModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @ActivityContext
    @Provides
    Context provideActivityContext() {
        return mActivity;
    }

    @PerActivity
    @Provides
    HomeMvpPresenter<HomeMvpView> providesHomeMvpPresenter(
            HomePresenter<HomeMvpView> homePresenter) {
        return homePresenter;
    }

    @PerActivity
    @Provides
    CurrentWeatherMvpPresenter<CurrentWeatherMvpView> viewCurrentWeatherMvpPresenter(
            CurrentWeatherPresenter<CurrentWeatherMvpView> currentWeatherMvpPresenter) {
        return currentWeatherMvpPresenter;
    }

    @PerActivity
    @Provides
    LocationMvpPresenter<LocationMvpView> radarMvpViewRadarPresenter(
            LocationPresenter<LocationMvpView> radarPresenter) {
        return radarPresenter;
    }
}
