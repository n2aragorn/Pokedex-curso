package com.vmk.solutions.nazgul.pokedex;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vmk.solutions.nazgul.pokedex.network.PokeCallBack;
import com.vmk.solutions.nazgul.pokedex.network.models.Pokemon;
import com.vmk.solutions.nazgul.pokedex.network.models.PokemonListResponse;
import com.vmk.solutions.nazgul.pokedex.pokemon.PokemonAdapter;
import com.vmk.solutions.nazgul.pokedex.utils.Constant;
import com.vmk.solutions.nazgul.pokedex.utils.DialogManager;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokedexActivity extends BaseActivity {

    List<Pokemon> pokemonList;
    PokemonAdapter adapters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);

        final EditText etPokeAdd = findViewById(R.id.etPokeAdd);
        Button btPokeAdd = findViewById(R.id.btPokeAdd);

        btPokeAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String poke = etPokeAdd.getText().toString();

                if (poke.isEmpty()){
                    return;
                }

                Pokemon pokemon = new Pokemon(poke, "");

                pokemonList.add(0, pokemon);
                adapters.notifyDataSetChanged();
            }
        });

        final RecyclerView rvPokemonList = findViewById(R.id.rvPokemonList);

        Call<PokemonListResponse> call = loader.getPokemonList();

        call.enqueue(new PokeCallBack<PokemonListResponse>(PokedexActivity.this, true) {
            @Override
            public void onResponse(Call<PokemonListResponse> call, Response<PokemonListResponse> response) {
                super.onResponse(call, response);

                if (response.isSuccessful()){

                    pokemonList = response.body().getPokemonList();

                    adapters = new PokemonAdapter(pokemonList, PokedexActivity.this);

                    rvPokemonList.setAdapter(adapters);

                    rvPokemonList.setHasFixedSize(true);

                    RecyclerView.LayoutManager manager = new LinearLayoutManager(PokedexActivity.this);

                    rvPokemonList.setLayoutManager(manager);
                } else {
                    showDialogError();
                }
            }

            @Override
            public void onFailure(Call<PokemonListResponse> call, Throwable t) {
                super.onFailure(call, t);
                showDialogError();
            }
        });
    }


}
