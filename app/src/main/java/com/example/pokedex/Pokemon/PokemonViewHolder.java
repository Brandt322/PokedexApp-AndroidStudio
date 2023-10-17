package com.example.pokedex.Pokemon;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.R;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    TextView tvPokemonName;
    LinearLayout llPokemonContainer;
    public PokemonViewHolder(@NonNull View itemView) {
        super(itemView);

        tvPokemonName = itemView.findViewById(R.id.tvPokemonName);
        llPokemonContainer = itemView.findViewById(R.id.llPokemonContainer);
    }
}
