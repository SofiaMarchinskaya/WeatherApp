package com.example.weatherapp.data.network.model.airpollution;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AirPollution {
    @SerializedName("list")
    List<AirPollutionListItem> list;

    public List<AirPollutionListItem> getList() {
        return list;
    }
}