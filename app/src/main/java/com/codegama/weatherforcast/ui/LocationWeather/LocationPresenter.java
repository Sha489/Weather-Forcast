package com.codegama.weatherforcast.ui.LocationWeather;

import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.base.BasePresenter;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LocationPresenter<V extends LocationMvpView> extends BasePresenter<V> implements LocationMvpPresenter<V> {

    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Inject
    LocationPresenter(DataManager dataManager) {
        super(dataManager);
    }

    @Override
    public void getCurrentWeatherFromAPI(String endpoint) {
        getDataManager().getCurrentWeather(endpoint)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CurrentWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CurrentWeather currentWeatherResponse) {
                        if (!isViewAttached())
                            return;
                        getMvpView().getCurrentWeatherResponse(currentWeatherResponse);
                        getMvpView().hideLoading();
                    }

                    @Override
                    public void onError(Throwable t) {
                        if (!isViewAttached())
                            return;
                        getMvpView().hideLoading();
                    }

                    @Override
                    public void onComplete() {                      
                    }
                });
    }
}
