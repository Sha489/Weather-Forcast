package com.codegama.weatherforcast.di.module;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.codegama.weatherforcast.di.annotation.PerActivity;
import com.codegama.weatherforcast.util.AppConstants;

import java.util.ArrayList;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class UiModule {

    private final AppCompatActivity mActivity;

    public UiModule(AppCompatActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Provides
    @Named(AppConstants.DI.LAYOUT_MANAGER_VERTICAL)
    LinearLayoutManager provideLinearLayoutManagerVertical() {
        return new LinearLayoutManager(mActivity);
    }

    @Provides
    @Named(AppConstants.DI.LAYOUT_MANAGER_HORIZONTAL)
    LinearLayoutManager provideLinearLayoutManagerHorizontal() {
        return new LinearLayoutManager(mActivity, LinearLayoutManager.HORIZONTAL, false);
    }

}
