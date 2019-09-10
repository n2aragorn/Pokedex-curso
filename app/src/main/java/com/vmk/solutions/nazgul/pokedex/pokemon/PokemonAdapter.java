package com.vmk.solutions.nazgul.pokedex.pokemon;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vmk.solutions.nazgul.pokedex.PokemonDetailActivity;
import com.vmk.solutions.nazgul.pokedex.R;
import com.vmk.solutions.nazgul.pokedex.network.models.Pokemon;
import com.vmk.solutions.nazgul.pokedex.utils.Constant;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonViewHolder> {
    List<Pokemon> pokemonList;
    Context ctx;

    public PokemonAdapter(List<Pokemon> pokemonList, Context ctx) {
        this.pokemonList = pokemonList;
        this.ctx = ctx;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_pokemon, parent, false);

        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final PokemonViewHolder holder, int i) {
        holder.tvPokemonName.setText(pokemonList.get(i).getName());

        holder.tvPokemonName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pokemonId = pokemonList.get(holder.getAdapterPosition()).getName();

                Intent intent = new Intent(ctx, PokemonDetailActivity.class);
                intent.putExtra(Constant.EXTRA_POKEMON_ID, pokemonId);
                ctx.startActivity(intent);
            }
        });

        holder.btPokemonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pokemonList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }
}
