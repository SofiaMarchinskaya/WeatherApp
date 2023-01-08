package com.example.weatherapp.data.network;

import com.example.weatherapp.Constants;
import com.example.weatherapp.data.network.model.Weather;
import com.example.weatherapp.data.network.model.airpollution.AirPollution;

import java.io.IOException;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class WeatherServiceImpl implements WeatherService {
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(Constants.OPEN_WEATHER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
    WeatherApi weatherApi = retrofit.create(WeatherApi.class);

    @Override
    public Weather getDailyWeather(String lat, String lon) throws IOException {
        return weatherApi.weatherList(lat,
                lon, Constants.OPEN_API_KEY, Constants.METRIC_UNITS).execute().body();
    }

    @Override
    public AirPollution getAirPollution(String lat, String lon ) throws IOException {
        return weatherApi.pollutionList(lat,
                lon, Constants.OPEN_API_KEY, Constants.METRIC_UNITS).execute().body();
    }
}
