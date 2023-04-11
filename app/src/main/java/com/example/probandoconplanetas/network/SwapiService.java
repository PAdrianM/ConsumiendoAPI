package com.example.probandoconplanetas.network;

import com.example.probandoconplanetas.models.Planet;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Part;
import retrofit2.http.Path;

public interface SwapiService {
    @GET("planets/")
    Call<PlanetResponse> getPlanets();

    @GET("planets/{id}")
    Call<Planet> getPlanet(@Path("id") int id);
}
