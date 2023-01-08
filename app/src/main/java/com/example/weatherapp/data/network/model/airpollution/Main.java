package com.example.weatherapp.data.network.model.airpollution;

import com.google.gson.annotations.SerializedName;


public class Main {

    @SerializedName("aqi")
    int aqi;

    public int getAqi() {
        return aqi;
    }
}