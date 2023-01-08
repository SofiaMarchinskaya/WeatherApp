
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

public class DailyWeather {

    @SerializedName("id")

    private Double id;
    @SerializedName("main")

    private String main;
    @SerializedName("description")

    private String description;
    @SerializedName("icon")

    private String icon;

    public Double getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }

}
