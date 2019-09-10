package com.vmk.solutions.nazgul.pokedex.pokemon;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.vmk.solutions.nazgul.pokedex.R;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    TextView tvPokemonName;
    LinearLayout llPokemonConteiner;
    Button btPokemonDelete;

    public PokemonViewHolder(@NonNull View v) {
        super(v);

        tvPokemonName = v.findViewById(R.id.tvPokemonName);
        llPokemonConteiner = v.findViewById(R.id.llPokemonConteiner);
        btPokemonDelete = v.findViewById(R.id.btPokemonDelete);
    }
}
