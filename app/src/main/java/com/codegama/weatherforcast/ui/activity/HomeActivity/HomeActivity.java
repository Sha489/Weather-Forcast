package com.codegama.weatherforcast.ui.activity.HomeActivity;

import android.content.Context;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.codegama.weatherforcast.R;
import com.codegama.weatherforcast.data.DataManager;
import com.codegama.weatherforcast.ui.LocationWeather.LocationWeatherFragment;
import com.codegama.weatherforcast.ui.base.BaseActivity;
import com.codegama.weatherforcast.ui.fragment.CurrentWeather.CurrentWeatherFragment;
import com.codegama.weatherforcast.util.AppConstants;
import com.google.android.material.tabs.TabLayout;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.inflationx.viewpump.ViewPumpContextWrapper;

public class HomeActivity extends BaseActivity implements HomeMvpView {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabLayout)
    TabLayout tabLayout;
    private static final String TAG = HomeActivity.class.getSimpleName();

    @Inject
    HomeMvpPresenter<HomeMvpView> mPresenter;
    @Inject
    @Named(AppConstants.DI.LAYOUT_MANAGER_VERTICAL)
    Provider<LinearLayoutManager> layoutManagerProvider;
    @Inject
    DataManager dataManager;

    @Inject
    @Named(AppConstants.DI.LAYOUT_MANAGER_VERTICAL)
    Provider<LinearLayoutManager> linearLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        mPresenter.onAttach(this);

        setUpTabLayout();

        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    protected void setUp() {

    }

    public void setUpTabLayout() {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new CurrentWeatherFragment(), getString(R.string.currentWeather));
        adapter.addFragment(new LocationWeatherFragment(), getString(R.string.location));
//        adapter.addFragment(new CurrentWeatherFragment(), getString(R.string.radar));
//        adapter.addFragment(new CurrentWeatherFragment(), getString(R.string.settings));
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(ViewPumpContextWrapper.wrap(newBase));
    }

    @Override
    public void openNotificationScreen() {

    }
}
