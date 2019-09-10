package com.vmk.solutions.nazgul.pokedex;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.vmk.solutions.nazgul.pokedex.network.PokemonLoader;
import com.vmk.solutions.nazgul.pokedex.utils.DialogManager;

public class BaseActivity extends AppCompatActivity {

    public PokemonLoader loader;
    private ProgressDialog progress;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loader = new PokemonLoader();
        progress = new ProgressDialog(this);
    }

    public void showProgress(){
        progress.setCancelable(false);
        progress.setMessage("Cargando...");
        progress.show();
    }

    public void hideProgress() {
        if (progress.isShowing())
            progress.dismiss();
    }

    public void showDialogError() {
        DialogManager manager = new DialogManager(BaseActivity.this, "ERROR", "Error del Servidor!");

        Dialog dialog = manager.buildDialog();

        dialog.show();

        manager.getBtDialog().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
