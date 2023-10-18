package com.example.pokedex.Pokemon;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pokedex.PokemonDetailActivity;
import com.example.pokedex.R;
import com.example.pokedex.network.model.Pokemon;
import com.example.pokedex.utils.Constant;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {

    List<Pokemon> pokemonList;
    Context context;

    public PokemonAdapter(List<Pokemon> pokemonList, Context context) {
        this.pokemonList = pokemonList;
        this.context = context;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);
        return new PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, final int position) {
        holder.tvPokemonName.setText(pokemonList.get(position).getName());

        holder.llPokemonContainer.setOnClickListener(v -> {
            String pokemonId = pokemonList.get(position).getName();

            Intent intent = new Intent(context, PokemonDetailActivity.class);
            intent.putExtra(Constant.POKEMON_ID, pokemonId);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
