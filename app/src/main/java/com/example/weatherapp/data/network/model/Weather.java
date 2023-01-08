
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Weather {

    @SerializedName("cod")
    private String cod;
    @SerializedName("message")
    private Integer message;
    @SerializedName("cnt")
    private Integer cnt;
    @SerializedName("list")
    private List<DailyWeatherListItem> list = null;
    @SerializedName("city")
    private City city;

    public String getCod() {
        return cod;
    }

    public Integer getMessage() {
        return message;
    }

    public Integer getCnt() {
        return cnt;
    }

    public List<DailyWeatherListItem> getList() {
        return list;
    }

    public City getCity() {
        return city;
    }

}
