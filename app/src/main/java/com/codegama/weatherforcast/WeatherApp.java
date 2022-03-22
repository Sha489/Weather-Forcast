package com.codegama.weatherforcast;

import android.app.Application;

import com.codegama.weatherforcast.di.component.ApplicationComponent;
import com.codegama.weatherforcast.di.component.DaggerApplicationComponent;
import com.codegama.weatherforcast.di.module.ApplicationModule;

import io.github.inflationx.calligraphy3.CalligraphyConfig;
import io.github.inflationx.calligraphy3.CalligraphyInterceptor;
import io.github.inflationx.viewpump.ViewPump;

public class WeatherApp extends Application {

    private ApplicationComponent applicationComponent;

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        ViewPump.init(
                ViewPump.builder()
                        .addInterceptor(
                                new CalligraphyInterceptor(
                                        new CalligraphyConfig.Builder()
                                                .setDefaultFontPath("fonts/nunito_light.ttf")
                                                .setFontAttrId(R.attr.fontPath)
                                                .build()
                                )
                        )
                        .build()
        );
    }
}
