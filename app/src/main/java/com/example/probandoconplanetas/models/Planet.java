package com.example.probandoconplanetas.models;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Planet  {
    @SerializedName("name")
    private String name;

    @SerializedName("climate")
    private String climate;

    @SerializedName("terrain")
    private String terrain;

    @SerializedName("population")
    private String population;

    @SerializedName("url")
    private String url;

    public String getName() {
        return name;
    }

    public String getClimate() {
        return climate;
    }

    public String getTerrain() {
        return terrain;
    }

    public String getPopulation() {
        return population;
    }

    public String getUrl() {
        return url;
    }
}
