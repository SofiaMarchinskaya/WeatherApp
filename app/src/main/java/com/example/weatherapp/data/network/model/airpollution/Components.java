package com.example.weatherapp.data.network.model.airpollution;

import com.google.gson.annotations.SerializedName;


public class Components {

    @SerializedName("co")
    double co;

    @SerializedName("no")
    double no;

    @SerializedName("no2")
    double no2;

    @SerializedName("o3")
    double o3;

    @SerializedName("so2")
    double so2;

    @SerializedName("pm2_5")
    double pm25;

    @SerializedName("pm10")
    double pm10;

    @SerializedName("nh3")
    double nh3;

    public double getCo() {
        return co;
    }

    public double getNo() {
        return no;
    }

    public double getNo2() {
        return no2;
    }

    public double getO3() {
        return o3;
    }

    public double getSo2() {
        return so2;
    }

    public double getPm25() {
        return pm25;
    }

    public double getPm10() {
        return pm10;
    }

    public double getNh3() {
        return nh3;
    }
}