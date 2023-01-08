package com.example.weatherapp.domain;

import com.example.weatherapp.data.network.model.Weather;
import com.example.weatherapp.data.network.model.airpollution.AirPollution;

import java.io.IOException;

public interface WeatherRepository {
    Weather getWeather(String lat, String lon) throws IOException;
    AirPollution getAirPollution(String lat, String lon) throws IOException;
}
