package com.example.probandoconplanetas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.probandoconplanetas.MainActivity;
import com.example.probandoconplanetas.R;
import com.example.probandoconplanetas.models.Planet;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PlanetViewHolder> {

    private List<Planet> planetList;

    public RecyclerAdapter(MainActivity mainActivity, List<Planet> planetList) {
        this.planetList = planetList;
    }

    @NonNull
    @Override
    public PlanetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_planet, parent, false);
        return new PlanetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlanetViewHolder holder, int position) {
        Planet planet = planetList.get(position);
        holder.bind(planet);
    }

    @Override
    public int getItemCount() {
        return planetList.size();
    }

    static class PlanetViewHolder extends RecyclerView.ViewHolder {

        private TextView nameTextView;
        private TextView climateTextView;
        private TextView terrainTextView;
        private TextView populationTextView;

        PlanetViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.terrainTextView);
            climateTextView = itemView.findViewById(R.id.climateTextView);
            terrainTextView = itemView.findViewById(R.id.terrainTextView);
            populationTextView = itemView.findViewById(R.id.populationTextView);
        }

        void bind(Planet planet) {
            nameTextView.setText("Name: " + planet.getName());
            climateTextView.setText("Climate: " + planet.getClimate());
            terrainTextView.setText("Terrain: " + planet.getTerrain());
            populationTextView.setText("Population: " + planet.getPopulation());
            String dosCaracteres = planet.getUrl().substring(planet.getUrl().length() - 2);
        }
    }
}
