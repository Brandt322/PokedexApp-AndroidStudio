package com.example.pokedex.network;

import com.example.pokedex.network.model.PokemonByIdResponse;
import com.example.pokedex.network.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface PokemonApi {
    @GET("pokemon")
    Call<PokemonResponse> getPokemonResponse();

    @GET("pokemon/{id}")
    Call<PokemonByIdResponse> getPokemonById(@Path("id")String id);
}
