package com.vmk.solutions.nazgul.pokedex.network;

import com.vmk.solutions.nazgul.pokedex.network.models.PokemonByIdResponse;
import com.vmk.solutions.nazgul.pokedex.network.models.PokemonListResponse;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class PokemonLoader implements PokemonAPI {

    PokemonAPI pokemonAPI;
    final String URL_BASE = "https://pokeapi.co/api/v2/";

    public PokemonLoader() {
        Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(URL_BASE)
                                .addConverterFactory(GsonConverterFactory.create())
                                .build();

        pokemonAPI = retrofit.create(PokemonAPI.class);
    }

    @Override
    public Call<PokemonListResponse> getPokemonList() {
        return pokemonAPI.getPokemonList();
    }

    @Override
    public Call<PokemonByIdResponse> getPokemonById(String id) {
        return pokemonAPI.getPokemonById(id);
    }
}
