package com.example.pokedex.network.model;

import com.google.gson.annotations.SerializedName;

public class Games {
    @SerializedName("game_index")
    private int gameIndex;
    private Version version;

    public int getGameIndex() {
        return gameIndex;
    }

    public Version getVersion() {
        return version;
    }

    class Version {
        private String name;
        private String url;

        public String getName() {
            return name;
        }

        public String getUrl() {
            return url;
        }
    }
}
