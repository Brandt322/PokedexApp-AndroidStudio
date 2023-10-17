package com.example.pokedex.network.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PokemonResponse {
    private int id;
    private String next;
    private String previous;
    @SerializedName("results")
    private List<Pokemon> pokemonsList;

    public int getId() {
        return id;
    }

    public String getNext() {
        return next;
    }

    public String getPrevious() {
        return previous;
    }

    public List<Pokemon> getPokemonsList() {
        return pokemonsList;
    }
}
