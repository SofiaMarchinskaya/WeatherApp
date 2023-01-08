package com.example.weatherapp.presentation;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.weatherapp.data.WeatherRepositoryImpl;
import com.example.weatherapp.data.network.model.Weather;
import com.example.weatherapp.data.network.model.airpollution.AirPollution;
import com.example.weatherapp.domain.WeatherRepository;

import java.io.IOException;

public class WeatherViewModel extends ViewModel {
    private String defaultLat = "55.7718";
    private String defaultLon = "37.69669";
    private String lat = null;
    private String lon = null;
    private MutableLiveData<Boolean> _forceUpdate = new MutableLiveData();
    LiveData<Boolean> forceUpdate = _forceUpdate;
    WeatherRepository repository = new WeatherRepositoryImpl();
    private MutableLiveData<Weather> _weather = new MutableLiveData<>();
    LiveData<Weather> weather = _weather;
    private MutableLiveData<AirPollution> _airPollution = new MutableLiveData<>();
    LiveData<AirPollution> airPollution = _airPollution;

    public WeatherViewModel() {
        updateWeather(defaultLat, defaultLon);
    }

    void updateWeather(String lat, String lon) {
        this.lat = lat;
        this.lon = lon;
        getWeather(lat, lon);
    }

    void onRefresh(){
       getWeather(lat, lon);
    }

    private void loadDailyWeather(String lat, String lon) {
        new Thread(() -> {
            try {
                _weather.postValue(repository.getWeather(lat, lon));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void loadAirPollution(String lat, String lon) {
        new Thread(() -> {
            try {
                _airPollution.postValue(repository.getAirPollution(lat, lon));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void getWeather(String lat, String lon) {
        _forceUpdate.setValue(true);
        loadDailyWeather(lat, lon);
        loadAirPollution(lat, lon);
        _forceUpdate.setValue(false);
    }
}
