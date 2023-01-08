
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

public class City {

    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private Coord coord;
    @SerializedName("country")
    private String country;
    @SerializedName("population")
    private Integer population;
    @SerializedName("timezone")
    private Integer timezone;
    @SerializedName("sunrise")
    private Double sunrise;
    @SerializedName("sunset")
    private Double sunset;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Coord getCoord() {
        return coord;
    }

    public String getCountry() {
        return country;
    }

    public Integer getPopulation() {
        return population;
    }

    public Integer getTimezone() {
        return timezone;
    }

    public Double getSunrise() {
        return sunrise;
    }

    public Double getSunset() {
        return sunset;
    }
}
