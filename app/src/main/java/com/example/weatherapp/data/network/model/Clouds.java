
package com.example.weatherapp.data.network.model;

import com.google.gson.annotations.SerializedName;

public class Clouds {
    @SerializedName("all")
    private Integer all;

    public Integer getAll() {
        return all;
    }
}
