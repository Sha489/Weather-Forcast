package com.codegama.weatherforcast.ui.fragment.CurrentWeather;

import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.activity.HomeActivity.HomeMvpPresenter;
import com.codegama.weatherforcast.ui.activity.HomeActivity.HomeMvpView;
import com.codegama.weatherforcast.ui.base.BasePresenter;

import org.json.JSONObject;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;

public class CurrentWeatherPresenter<V extends CurrentWeatherMvpView> extends BasePresenter<V>
        implements CurrentWeatherMvpPresenter<V> {


    @Override
    public void onAttach(V mvpView) {
        super.onAttach(mvpView);
    }

    @Inject
    CurrentWeatherPresenter(DataManager dataManager) {
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
                        getMvpView().onError("Something went wrong");
                        getMvpView().hideLoading();
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }
}
