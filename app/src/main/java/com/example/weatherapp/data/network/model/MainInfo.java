
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

public class MainInfo {

    @SerializedName("temp")
    private Double temp;
    @SerializedName("feels_like")
    private Double feelsLike;
    @SerializedName("temp_min")
    private Double tempMin;
    @SerializedName("temp_max")
    private Double tempMax;
    @SerializedName("pressure")
    private Double pressure;
    @SerializedName("sea_level")
    private Double seaLevel;
    @SerializedName("grnd_level")
    private Double grndLevel;
    @SerializedName("humidity")
    private Double humidity;
    @SerializedName("temp_kf")
    private Double tempKf;

    public Double getTemp() {
        return temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public Double getTempMin() {
        return tempMin;
    }

    public Double getTempMax() {
        return tempMax;
    }

    public Double getPressure() {
        return pressure;
    }

    public Double getSeaLevel() {
        return seaLevel;
    }

    public Double getGrndLevel() {
        return grndLevel;
    }

    public Double getHumidity() {
        return humidity;
    }

    public Double getTempKf() {
        return tempKf;
    }
}
