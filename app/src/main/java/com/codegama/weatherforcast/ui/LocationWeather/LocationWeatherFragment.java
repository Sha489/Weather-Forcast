package com.codegama.weatherforcast.ui.LocationWeather;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.bumptech.glide.Glide;
import com.codegama.weatherforcast.R;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.base.BaseFragment;
import com.codegama.weatherforcast.util.AppConstants;

import java.util.ArrayList;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

import static com.codegama.weatherforcast.ui.LocationWeather.LocationWeatherAdapter.temperature;
import static com.codegama.weatherforcast.ui.LocationWeather.LocationWeatherAdapter.temperatureName;
import static com.codegama.weatherforcast.ui.LocationWeather.LocationWeatherAdapter.weatherImage;

public class LocationWeatherFragment extends BaseFragment implements LocationMvpView {

    @Inject
    @Named(AppConstants.DI.LAYOUT_MANAGER_VERTICAL)
    Provider<LinearLayoutManager> layoutManagerProvider;

    @Inject
    LocationMvpPresenter<LocationMvpView> radarMvpPresenter;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    int pos;

    public LocationWeatherFragment() {
    }

    Unbinder unbinder;
    LocationWeatherAdapter locationWeatherAdapter;
    CurrentWeather itemCurrentWeather;
    public static ArrayList<CurrentWeather> weather = new ArrayList<>();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        getBaseActivity().onFragmentAttached();
    }

    @Override
    public void onDetach() {
        getBaseActivity().onFragmentDetached(getTag());
        super.onDetach();
    }

    @Override
    public void setup() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_radar_fragment, container, false);
        unbinder = ButterKnife.bind(this, view);
        getBaseActivity().getActivityComponent().inject(this);
        radarMvpPresenter.onAttach(this);
        setUpPagerData();
        setUpAdapter();

        viewPager.addOnPageChangeListener(new   ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pos = position;
                radarMvpPresenter.getCurrentWeatherFromAPI("https://api.openweathermap.org/data/2.5/weather?q=" + weather.get(pos).getCity() + "&appid=a27a4148745d2dc7e026b7a869d5a6f9");
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        return view;
    }


    public void setUpPagerData() {
        weather.add(new CurrentWeather("Weather forecast location wise", "https://cdn.dribbble.com/users/772985/screenshots/8502919/media/61640071cb5ad714d45e4155313584b8.gif"));
        weather.add(new CurrentWeather("Bangalore", "https://static.toiimg.com/thumb/msid-54559212,width-748,height-499,resizemode=4,imgsize-307081/Bangalore.jpg"));
        weather.add(new CurrentWeather("Agara", "https://static.langimg.com/thumb/msid-64917060,width-400,resizemode-4/pic.jpg"));
        weather.add(new CurrentWeather("London", "https://secretldn.com/wp-content/uploads/2019/08/Lonely-Planet-1.jpg"));
        weather.add(new CurrentWeather("Paris", "https://images.unsplash.com/photo-1502602898657-3e91760cbb34?ixlib=rb-1.2.1&w=1000&q=80"));
        weather.add(new CurrentWeather("Switzerland", "https://pullman.accorhotels.com/destinations/imagerie/switzerland-country-photo-1400x788px-0276_1400x788.jpg"));
        weather.add(new CurrentWeather("Leh", "https://media.cntraveller.in/wp-content/uploads/2018/07/LadakhLead-866x487.jpg"));
        weather.add(new CurrentWeather("Malé", "https://cache.marriott.com/marriottassets/marriott/MLEWH/mlewh-wow-oceanhaven-1800-hor-wide.jpg?interpolation=progressive-bilinear&downsize=1440px:*"));
        weather.add(new CurrentWeather("Alleppey", "https://seoimgak.mmtcdn.com/blog/sites/default/files/explore-alleppey-.jpg"));
        weather.add(new CurrentWeather("Chiang Mai", "https://media.cntraveller.in/wp-content/uploads/2015/05/krabithailand-866x487.jpg"));
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    public void setUpAdapter() {
        locationWeatherAdapter = new LocationWeatherAdapter(getActivity(), itemCurrentWeather);
        viewPager.setAdapter(locationWeatherAdapter);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void getCurrentWeatherResponse(CurrentWeather currentWeather) {
        double tempInCelsius = currentWeather.getMain().getTemp() - 273.15;
        temperature.setText(String.format("%s%s%s", String.valueOf(Math.round(tempInCelsius)), (char) 0x00B0, "C"));
        temperatureName.setText(String.format("%s | %s", currentWeather.getWeather().get(0).getMain(), currentWeather.getWeather().get(0).getDescription()));
        switch (currentWeather.getWeather().get(0).getMain()) {
            case "Thunderstorm":
                Glide.with(getActivity()).load(R.drawable.thunderstorm_image).into(weatherImage);
                break;
            case "Drizzle":
                Glide.with(getActivity()).load(R.drawable.drizzle_image).into(weatherImage);
                break;
            case "Rain":
                Glide.with(getActivity()).load(R.drawable.rain_image).into(weatherImage);
                break;
            case "Snow":
                Glide.with(getActivity()).load(R.drawable.snowflake_image).into(weatherImage);
                break;
            case "Clear":
                Glide.with(getActivity()).load(R.drawable.sun_image).into(weatherImage);
                break;
            case "Clouds":
                Glide.with(getActivity()).load(R.drawable.cloudy_image).into(weatherImage);
                break;
            case "Mist":
            case "Smoke":
            case "Haze":
            case "Dust":
            case "Fog":
            case "Sand":
            case "Ash":
            case "Squall":
                Glide.with(getActivity()).load(R.drawable.smog).into(weatherImage);
                break;
            case "Tornado":
                Glide.with(getActivity()).load(R.drawable.tornado).into(weatherImage);
                break;
        }
    }
}
