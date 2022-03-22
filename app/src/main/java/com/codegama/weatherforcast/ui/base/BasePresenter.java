package com.codegama.weatherforcast.ui.base;

import com.codegama.weatherforcast.data.DataManager;

public class BasePresenter<V extends MvpView> implements MvpPresenter<V> {

    private V mvpView;

    private DataManager dataManager;

    public BasePresenter(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    public boolean isViewAttached() {
        return mvpView != null;
    }

    @Override
    public void onAttach(V mvpView) {
        this.mvpView = mvpView;
    }

    public V getMvpView() {
        return mvpView;
    }

    @Override
    public void onDetach() {
        mvpView = null;
    }

    @Override
    public void handleApiError() {

    }
}
