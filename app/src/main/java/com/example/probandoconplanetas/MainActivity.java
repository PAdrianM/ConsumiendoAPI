package com.example.probandoconplanetas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.probandoconplanetas.adapter.RecyclerAdapter;
import com.example.probandoconplanetas.models.Planet;
import com.example.probandoconplanetas.network.PlanetResponse;
import com.example.probandoconplanetas.network.SwapiClient;
import com.example.probandoconplanetas.network.SwapiService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.rv_planet);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SwapiService swapiService = SwapiClient.getClient().create(SwapiService.class);
        Call<PlanetResponse> call = swapiService.getPlanets();
        call.enqueue(new Callback<PlanetResponse>() {
            @Override
            public void onResponse(Call<PlanetResponse> call, Response<PlanetResponse> response) {
                if (response.isSuccessful()){
                    Toast.makeText(MainActivity.this, "CONEXION ESTABLECIDA", Toast.LENGTH_SHORT).show();
                    List<Planet> planets = response.body().getResults();
                    adapter = new RecyclerAdapter(MainActivity.this, planets);
                    recyclerView.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<PlanetResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR DE CONEXION", Toast.LENGTH_SHORT).show();
            }
        });
    }
}