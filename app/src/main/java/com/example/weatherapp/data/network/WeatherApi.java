package com.example.weatherapp.data.network;

import com.example.weatherapp.data.network.model.Weather;
import com.example.weatherapp.data.network.model.airpollution.AirPollution;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherApi {
    @GET("forecast")
    Call<Weather> weatherList(@Query("lat") String lat,
                              @Query("lon") String lon,
                              @Query("appid") String appid,
                              @Query("units") String units
    );

    @GET("air_pollution")
    Call<AirPollution> pollutionList(@Query("lat") String lat,
                                     @Query("lon") String lon,
                                     @Query("appid") String appid,
                                     @Query("units") String units);
}
