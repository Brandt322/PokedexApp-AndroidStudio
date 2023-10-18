package com.example.pokedex.network;

import com.example.pokedex.network.model.PokemonByIdResponse;
import com.example.pokedex.network.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonLoader implements PokemonApi {

    PokemonApi pokemonApi;
    final String POKEAPI_URL="https://pokeapi.co/api/v2/";
    public PokemonLoader() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(POKEAPI_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        pokemonApi = retrofit.create(PokemonApi.class);
    }

    @Override
    public Call<PokemonResponse> getPokemonResponse() {
        return pokemonApi.getPokemonResponse();
    }

    @Override
    public Call<PokemonByIdResponse> getPokemonById(String id) {
        return pokemonApi.getPokemonById(id);
    }
}
