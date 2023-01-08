package com.example.weatherapp.data.network.model.airpollution;

import com.google.gson.annotations.SerializedName;

   
public class AirPollutionListItem {

   @SerializedName("dt")
   int dt;

   @SerializedName("main")
   Main main;

   @SerializedName("components")
   Components components;

    public int getDt() {
        return dt;
    }

    public Main getMain() {
        return main;
    }

    public Components getComponents() {
        return components;
    }
}