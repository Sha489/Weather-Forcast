package com.codegama.weatherforcast.di.component;


import com.codegama.weatherforcast.di.annotation.PerActivity;
import com.codegama.weatherforcast.di.module.ActivityModule;
import com.codegama.weatherforcast.di.module.UiModule;
import com.codegama.weatherforcast.ui.LocationWeather.LocationWeatherFragment;
import com.codegama.weatherforcast.ui.activity.HomeActivity.HomeActivity;
import com.codegama.weatherforcast.ui.fragment.CurrentWeather.CurrentWeatherFragment;

import dagger.Component;

@PerActivity
@Component(modules = {ActivityModule.class, UiModule.class},
        dependencies = ApplicationComponent.class)
public interface ActivityComponent {

    void inject(HomeActivity homeActivity);

    void inject(CurrentWeatherFragment currentWeatherFragment);

    void inject(LocationWeatherFragment radarFragment);

}
