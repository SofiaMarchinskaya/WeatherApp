
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

public class Wind {

    @SerializedName("speed")

    private Double speed;
    @SerializedName("deg")

    private Integer deg;
    @SerializedName("gust")

    private Double gust;

    public Double getSpeed() {
        return speed;
    }

    public Integer getDeg() {
        return deg;
    }

    public Double getGust() {
        return gust;
    }

}
