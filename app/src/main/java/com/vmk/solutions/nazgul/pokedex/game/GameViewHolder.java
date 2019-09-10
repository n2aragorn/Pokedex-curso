package com.vmk.solutions.nazgul.pokedex.game;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.vmk.solutions.nazgul.pokedex.R;

public class GameViewHolder extends RecyclerView.ViewHolder {

    TextView tvGame;

    public GameViewHolder(@NonNull View v) {
        super(v);

        tvGame = v.findViewById(R.id.tvGame);
    }
}
