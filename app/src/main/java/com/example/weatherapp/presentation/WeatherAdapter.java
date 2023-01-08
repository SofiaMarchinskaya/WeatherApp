package com.example.weatherapp.presentation;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weatherapp.data.network.model.DailyWeatherListItem;
import com.example.weatherapp.databinding.DailyForecastItemBinding;

import java.util.ArrayList;
import java.util.List;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder> {
    private List<DailyWeatherListItem> weatherList = new ArrayList<>();

    @NonNull
    @Override
    public WeatherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WeatherViewHolder(DailyForecastItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull WeatherViewHolder holder, int position) {
        holder.bind(weatherList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherList.size();
    }

    public void updateWeatherList(List<DailyWeatherListItem> list) {
        weatherList = list;
        notifyDataSetChanged();
    }

    static class WeatherViewHolder extends RecyclerView.ViewHolder {
        private final DailyForecastItemBinding binding;

        WeatherViewHolder(DailyForecastItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(DailyWeatherListItem dailyWeatherListItem) {
            binding.date.setText(dailyWeatherListItem.getDtTxt());
            binding.temperatureText.setText(dailyWeatherListItem.getMain().getTemp() + "");
            binding.realFeel.setText(dailyWeatherListItem.getWeather().get(0).getDescription());
        }
    }
}
