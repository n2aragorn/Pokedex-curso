package com.vmk.solutions.nazgul.pokedex.network.models;

import com.google.gson.annotations.SerializedName;

public class Games {
    @SerializedName("game_indices")
    private int gameIndices;
    private Version version;

    public int getGameIndices() {
        return gameIndices;
    }

    public Version getVersion() {
        return version;
    }

    public class Version {
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
