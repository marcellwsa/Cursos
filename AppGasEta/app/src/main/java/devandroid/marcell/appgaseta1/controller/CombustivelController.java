package devandroid.marcell.appgaseta1.controller;

import android.content.SharedPreferences;

import devandroid.marcell.appgaseta1.model.Combustivel;
import devandroid.marcell.appgaseta1.view.GasEtaActivity;

public class CombustivelController {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity gasEtaActivity) {

        preferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel) {

        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("Recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

    }

    public void limpar() {
        dadosPreferences.clear();
        dadosPreferences.apply();

    }



}
