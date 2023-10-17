package com.example.pokedex.network;

import com.example.pokedex.network.model.PokemonResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PokemonApi {
    @GET("pokemon")
    Call<PokemonResponse> getPokemonResponse();
}
