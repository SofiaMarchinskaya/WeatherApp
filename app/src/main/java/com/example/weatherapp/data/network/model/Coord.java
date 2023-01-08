
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

public class Coord {

    @SerializedName("lat")
    private Double lat;
    @SerializedName("lon")
    private Double lon;

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }
}
