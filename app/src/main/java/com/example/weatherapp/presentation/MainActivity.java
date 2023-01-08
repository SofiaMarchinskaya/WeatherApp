package com.example.weatherapp.presentation;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.ViewModelProvider;

import com.example.weatherapp.Constants;
import com.example.weatherapp.data.network.model.DailyWeatherListItem;
import com.example.weatherapp.data.network.model.airpollution.Components;
import com.example.weatherapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private WeatherAdapter dailyWeatherAdapter;
    private WeatherViewModel viewModel;
    private Location location;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        viewModel = new ViewModelProvider(this).get(WeatherViewModel.class);
        dailyWeatherAdapter = new WeatherAdapter();
        binding.weatherRecycler.setAdapter(dailyWeatherAdapter);
        binding.swiperefresh.setOnRefreshListener(() ->
                viewModel.onRefresh());
        viewModel.forceUpdate.observe(this, update ->
                binding.swiperefresh.setRefreshing(update));
        viewModel.weather.observe(this, weather -> {
            DailyWeatherListItem todayForecast = weather.getList().get(0);
            dailyWeatherAdapter.updateWeatherList(weather.getList());
            binding.cityText.setText(weather.getCity().getName());
            binding.dateText.setText(todayForecast.getDtTxt());
            binding.temperatureText.setText(todayForecast.getMain().getTemp().intValue() + Constants.TEMP_UNIT);
            binding.realFeel.setText(todayForecast.getMain().getFeelsLike().intValue() + Constants.TEMP_UNIT);
            binding.weatherLabel.setText(todayForecast.getWeather().get(0).getDescription());

            binding.humidity.setText(todayForecast.getMain().getHumidity().intValue() + "%");
            binding.windSpeed.setText(todayForecast.getWind().getSpeed() + "m/s");
            binding.pressure.setText(todayForecast.getMain().getPressure().intValue() + "Pa");
        });
        viewModel.airPollution.observe(this, air -> {
            Components airPollution = air.getList().get(0).getComponents();
            binding.coIndex.setText(airPollution.getCo() + "");
            binding.noIndex.setText(airPollution.getNo() + "");
            binding.o3Index.setText(airPollution.getO3() + "");
            binding.so2Index.setText(airPollution.getSo2() + "");
        });

        if (ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this,
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION},
                    1);
        } else {
            location = new Location((LocationManager) getSystemService(LOCATION_SERVICE),
                    getApplicationContext(), (lat, lon) -> {
                viewModel.updateWeather(lat, lon);
            });
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                location = new Location((LocationManager) getSystemService(LOCATION_SERVICE),
                        getApplicationContext(), (lat, lon) -> {
                    viewModel.updateWeather(lat, lon);
                });
            } else {
                ActivityCompat
                        .requestPermissions(this, new String[]{Manifest.permission.INTERNET,
                                        Manifest.permission.ACCESS_FINE_LOCATION,
                                        Manifest.permission.ACCESS_COARSE_LOCATION,
                                }, 1);
            }
        }
    }
}
