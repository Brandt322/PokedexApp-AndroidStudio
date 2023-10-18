package com.example.pokedex.network.model;

import com.google.gson.annotations.SerializedName;

public class Sprite {
    @SerializedName("front_default")
    private String img;

    public String getImg() {
        return img;
    }
}
