package com.codegama.weatherforcast.ui.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.codegama.weatherforcast.R;
import com.codegama.weatherforcast.WeatherApp;
import com.codegama.weatherforcast.di.component.ActivityComponent;
import com.codegama.weatherforcast.di.component.DaggerActivityComponent;
import com.codegama.weatherforcast.di.module.ActivityModule;
import com.codegama.weatherforcast.di.module.UiModule;
import com.codegama.weatherforcast.util.CommonUtils;
import com.codegama.weatherforcast.util.KeyboardUtils;
import com.codegama.weatherforcast.util.NetworkUtils;
import com.google.android.material.snackbar.Snackbar;

import butterknife.Unbinder;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public abstract class BaseActivity extends AppCompatActivity implements MvpView,
        BaseFragment.Callback {

    private Unbinder mUnBinder;

    private ProgressDialog mProgressDialog;

    private ActivityComponent activityComponent;

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityComponent = DaggerActivityComponent.builder()
                .activityModule(new ActivityModule(this))
                .uiModule(new UiModule(this))
                .applicationComponent(((WeatherApp) getApplication()).getApplicationComponent())
                .build();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (NetworkUtils.isLocationPermissionsGiven(this)) {
            locationPermissionGranted();
        } else {
            locationPermissionNotGranted();
        }
    }

    public void locationPermissionNotGranted() {

    }

    public void locationPermissionGranted() {

    }

    @Override
    public void showLoading() {
        hideLoading();
        mProgressDialog = CommonUtils.showLoadingDialog(this);
    }

    @Override
    public void hideLoading() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.cancel();
        }
    }

    @Override
    public void onError(@StringRes int errorStrResId) {
        onError(getString(errorStrResId));
    }

    @Override
    public void onError(String errorMsg) {
        if (errorMsg != null) {
            showSnackBar(errorMsg);
        } else {
            showSnackBar(getString(R.string.something_went_wrong));
        }
    }

    @Override
    public void showShortToast(String message) {
        CommonUtils.showShortToast(this, message);
    }

    @Override
    public void showShortToast(@StringRes int msgResId) {
        CommonUtils.showShortToast(this, getString(msgResId));
    }

    @Override
    public void showLongToast(String message) {
        CommonUtils.showLongToast(this, message);
    }

    @Override
    public void showLongToast(@StringRes int msgResId) {
        CommonUtils.showLongToast(this, getString(msgResId));
    }

    @Override
    public void showSnackBar(String message) {
        Snackbar snackbar = Snackbar.make(findViewById(android.R.id.content),
                message, Snackbar.LENGTH_SHORT);
        View sbView = snackbar.getView();
        TextView textView = sbView
                .findViewById(com.google.android.material.R.id.snackbar_text);
        textView.setTextColor(ContextCompat.getColor(this, R.color.colorAccent));
        snackbar.show();
    }

    @Override
    public void showSnackBar(@StringRes int msgResId) {
        showSnackBar(getString(msgResId));
    }

    @Override
    public boolean isNetWorkConnected() {
        return NetworkUtils.isNetworkConnected(this);
    }

    @Override
    public void hideKeyboard() {
        KeyboardUtils.hideSoftInput(this);
    }

    public void setUnBinder(Unbinder unBinder) {
        mUnBinder = unBinder;
    }

    @Override
    protected void onDestroy() {
        if (mUnBinder != null) {
            mUnBinder.unbind();
        }
        super.onDestroy();
    }

    protected abstract void setUp();

    @Override
    public void onFragmentAttached() {

    }

    @Override
    public void onFragmentDetached(String tag) {

    }
}