package com.example.weatherapp.data;

import com.example.weatherapp.data.network.WeatherService;
import com.example.weatherapp.data.network.WeatherServiceImpl;
import com.example.weatherapp.data.network.model.Weather;
import com.example.weatherapp.data.network.model.airpollution.AirPollution;
import com.example.weatherapp.domain.WeatherRepository;

import java.io.IOException;

public class WeatherRepositoryImpl implements WeatherRepository {
    WeatherService ws = new WeatherServiceImpl();

    @Override
    public Weather getWeather(String lat, String lon) throws IOException {
        return ws.getDailyWeather(lat, lon);
    }

    @Override
    public AirPollution getAirPollution(String lat, String lon) throws IOException {
        return ws.getAirPollution(lat, lon);
    }
}
