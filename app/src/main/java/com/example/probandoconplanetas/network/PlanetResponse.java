package com.example.probandoconplanetas.network;

import com.example.probandoconplanetas.models.Planet;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PlanetResponse {
    @SerializedName("count")
    private int count;

    @SerializedName("next")
    private String next;

    @SerializedName("previous")
    private String previous;

    @SerializedName("results")
    private List<Planet> results;



    public int getCount() {
        return count;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Planet> getResults() {
        return results;
    }
}
