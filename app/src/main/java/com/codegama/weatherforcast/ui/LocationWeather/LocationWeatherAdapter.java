package com.codegama.weatherforcast.ui.LocationWeather;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.viewpager.widget.PagerAdapter;

import com.bumptech.glide.Glide;
import com.codegama.weatherforcast.R;
import com.codegama.weatherforcast.data.api.model.CurrentWeather;

import static com.codegama.weatherforcast.ui.LocationWeather.LocationWeatherFragment.weather;

public class LocationWeatherAdapter extends PagerAdapter {
    private Context context;
    CurrentWeather itemWeather;
    public static TextView temperature;
    public static TextView temperatureName;
    public static ImageView weatherImage;

    public LocationWeatherAdapter(Context context, CurrentWeather itemWeather) {
        this.context = context;
        this.itemWeather = itemWeather;
    }

    @Override
    public int getCount() {
        return weather.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView) object);
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull final ViewGroup container, final int position) {
        View view;
        view = LayoutInflater.from(container.getContext()).inflate(R.layout.item_location_weather, container, false);
        TextView location = view.findViewById(R.id.location);
        temperature = view.findViewById(R.id.temperature);
        temperatureName = view.findViewById(R.id.temperatureName);
        ImageView cityImage = view.findViewById(R.id.cityImage);
        weatherImage = view.findViewById(R.id.weatherImage);
        location.setText(weather.get(position).getCity());
        Glide.with(context).load(weather.get(position).getCityImage()).into(cityImage);
        container.addView(view);
        return view;
    }
}
