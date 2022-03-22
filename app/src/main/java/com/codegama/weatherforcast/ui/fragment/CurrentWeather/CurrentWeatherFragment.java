package com.codegama.weatherforcast.ui.fragment.CurrentWeather;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.codegama.weatherforcast.R;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;
import com.codegama.weatherforcast.ui.base.BaseFragment;
import com.codegama.weatherforcast.util.AppConstants;

import java.util.Date;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class CurrentWeatherFragment extends BaseFragment implements CurrentWeatherMvpView {

    @BindView(R.id.weatherGif)
    ImageView weatherGif;
    @BindView(R.id.temperature)
    TextView temperature;
    Unbinder unbinder;
    @BindView(R.id.first)
    ImageView first;
    @BindView(R.id.second)
    ImageView second;
    @BindView(R.id.third)
    ImageView third;
    @BindView(R.id.fourth)
    ImageView fourth;
    @BindView(R.id.fifth)
    ImageView fifth;
    @BindView(R.id.sixth)
    ImageView sixth;
    @BindView(R.id.weatherName)
    TextView weatherName;
    @BindView(R.id.globeImage)
    ImageView globeImage;

    @Inject
    @Named(AppConstants.DI.LAYOUT_MANAGER_VERTICAL)
    Provider<LinearLayoutManager> layoutManagerProvider;

    @Inject
    CurrentWeatherMvpPresenter<CurrentWeatherMvpView> currentWeatherMvpPresenter;
    @BindView(R.id.location)
    TextView location;
    @BindView(R.id.temp)
    TextView temp;
    @BindView(R.id.humidity)
    TextView humidity;
    @BindView(R.id.wind)
    TextView wind;

    public CurrentWeatherFragment() {

    }

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
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.layout_current_weather, container, false);
        unbinder = ButterKnife.bind(this, view);
        getBaseActivity().getActivityComponent().inject(this);
        currentWeatherMvpPresenter.onAttach(this);
        return view;
    }

    @Override
    public void setup() {

    }

    @Override
    public void onResume() {
        super.onResume();
        currentWeatherMvpPresenter.getCurrentWeatherFromAPI("https://api.openweathermap.org/data/2.5/weather?lat=12.770380&lon=77.616608&appid=a27a4148745d2dc7e026b7a869d5a6f9");
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void getCurrentWeatherResponse(CurrentWeather currentWeather) {
        double tempInCelsius = currentWeather.getMain().getTemp() - 273.15;
        location.setText(currentWeather.getLocation());
        temperature.setText(String.format("%s%s%s", String.valueOf(Math.round(tempInCelsius)), (char) 0x00B0, "C"));
        weatherName.setText(currentWeather.getWeather().get(0).getDescription());
        wind.setText(String.format("Wind: %s", String.valueOf(currentWeather.getWind().getSpeed())));
        temp.setText(String.format("Temperature in kelvin: %s", String.valueOf(currentWeather.getMain().getTemp())));
        humidity.setText(String.format("Humidity: %s", String.valueOf(currentWeather.getMain().getHumidity())));
        Date dt = new Date();
        int hours = dt.getHours();

        //get current UI mode...
        int currentNightMode = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;

        switch (currentWeather.getWeather().get(0).getMain()) {
            case "Thunderstorm":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.drawable.thunder_night).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        Glide.with(getActivity()).load(R.drawable.thunder_night).into(weatherGif);
                        break;
                }
                break;
            case "Drizzle":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.drawable.drizzle_mrng).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        Glide.with(getActivity()).load(R.drawable.drizzle_night).into(weatherGif);
                        break;
                }
                break;
            case "Rain":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.drawable.rain_mrng).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        Glide.with(getActivity()).load(R.drawable.rain_night).into(weatherGif);
                        break;
                }
                break;
            case "Snow":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:

                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
//                        Glide.with(getActivity()).load("https://cherokeebillie.files.wordpress.com/2020/01/snow-moon-gif.gif").into(weatherGif);
                        Glide.with(getActivity()).load("https://i.gifer.com/67Z.gif").into(weatherGif);
                        break;
                }
                break;
            case "Clear":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.raw.sun).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        Glide.with(getActivity()).load(R.drawable.moon_night).into(weatherGif);
                        break;
                }
                break;
            case "Clouds":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:

                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
//                        Glide.with(getActivity()).load("https://cdn.pixabay.com/photo/2015/09/05/20/07/log-924958__340.jpg").into(weatherGif);
                        Glide.with(getActivity()).load("https://cdn.pixabay.com/photo/2016/11/29/08/05/boats-1868291_960_720.jpg").into(weatherGif);
                        break;
                }
                break;
            case "Mist":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:

                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
//                        Glide.with(getActivity()).load("https://cdn.dribbble.com/users/1807105/screenshots/8116911/media/0bffb8b9dbc7570126db52b9fef37275.jpg").into(weatherGif);
                        Glide.with(getActivity()).load(R.drawable.mist).into(weatherGif);
                        break;
                }
                break;
            case "Smoke":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.drawable.smoke).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
                break;
            case "Haze":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
            case "Dust":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.drawable.haze).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
                break;
            case "Fog":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        Glide.with(getActivity()).load(R.drawable.fog).into(weatherGif);
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
                break;
            case "Sand":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
                break;
            case "Ash":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
                break;
            case "Squall":
                switch (currentNightMode) {
                    case Configuration.UI_MODE_NIGHT_NO:
                        break;
                    case Configuration.UI_MODE_NIGHT_YES:
                        break;
                }
                break;
        }
    }
}
