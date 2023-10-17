package com.example.pokedex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.pokedex.Pokemon.PokemonAdapter;
import com.example.pokedex.network.PokemonLoader;
import com.example.pokedex.network.model.Pokemon;
import com.example.pokedex.network.model.PokemonResponse;
import com.example.pokedex.utils.Constant;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvPokemonList = findViewById(R.id.rvPokemonList);
        PokemonLoader loader = new PokemonLoader();
        Call<PokemonResponse> call = loader.getPokemonResponse();

        call.enqueue(new Callback<PokemonResponse>() {
            @Override
            public void onResponse(Call<PokemonResponse> call, Response<PokemonResponse> response) {
                List<Pokemon> pokemonList = response.body().getPokemonsList();

                PokemonAdapter pokemonAdapter = new PokemonAdapter(pokemonList, MainActivity.this);
                rvPokemonList.setAdapter(pokemonAdapter);
                rvPokemonList.setHasFixedSize(true);

                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
                rvPokemonList.setLayoutManager(layoutManager);

            }

            @Override
            public void onFailure(Call<PokemonResponse> call, Throwable t) {
                Log.e(Constant.DEBUG_POKEMON, t.getMessage());
            }
        });
    }
}