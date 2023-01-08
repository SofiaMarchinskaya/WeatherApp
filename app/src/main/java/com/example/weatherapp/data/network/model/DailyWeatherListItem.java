
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DailyWeatherListItem {

    @SerializedName("dt")
    private Double dt;
    @SerializedName("main")
    private MainInfo main;
    @SerializedName("weather")
    private List<DailyWeather> weather = null;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("visibility")
    private Integer visibility;
    @SerializedName("pop")
    private Double pop;
    @SerializedName("sys")
    private Sys sys;
    @SerializedName("dt_txt")
    private String dtTxt;

    public Double getDt() {
        return dt;
    }

    public MainInfo getMain() {
        return main;
    }

    public List<DailyWeather> getWeather() {
        return weather;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Wind getWind() {
        return wind;
    }

    public Integer getVisibility() {
        return visibility;
    }

    public Double getPop() {
        return pop;
    }

    public Sys getSys() {
        return sys;
    }

    public String getDtTxt() {
        return dtTxt;
    }
}
