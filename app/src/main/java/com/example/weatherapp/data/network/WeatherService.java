package com.example.weatherapp.data.network;

import com.example.weatherapp.data.network.model.Weather;
import com.example.weatherapp.data.network.model.airpollution.AirPollution;

import java.io.IOException;

public interface WeatherService {
    Weather getDailyWeather(String lat, String lon) throws IOException;

    AirPollution getAirPollution(String lat, String lon) throws IOException;
}
