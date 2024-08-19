package devandroid.marcell.appgaseta1.controller;

import android.content.ContentValues;
import android.content.SharedPreferences;

import java.util.List;

import devandroid.marcell.appgaseta1.database.GasEtaDB;
import devandroid.marcell.appgaseta1.model.Combustivel;
import devandroid.marcell.appgaseta1.view.GasEtaActivity;

public class CombustivelController extends GasEtaDB {

    SharedPreferences preferences;
    SharedPreferences.Editor dadosPreferences;
    public static final String NOME_PREFERENCES = "pref_gaseta";

    public CombustivelController(GasEtaActivity gasEtaActivity) {
        super(gasEtaActivity);

        preferences = gasEtaActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        dadosPreferences = preferences.edit();

    }

    public void salvar(Combustivel combustivel) {

        ContentValues dados = new ContentValues();
        dados.put("nomeDoCombustivel", combustivel.getNomeDoCombustivel());
        dados.put("precoDoCombustivel", combustivel.getPrecoDoCombustivel());
        dados.put("recomendacao", combustivel.getRecomendacao());

        dadosPreferences.putString("combustivel", combustivel.getNomeDoCombustivel());
        dadosPreferences.putFloat("preco", (float) combustivel.getPrecoDoCombustivel());
        dadosPreferences.putString("Recomendacao", combustivel.getRecomendacao());
        dadosPreferences.apply();

        salvarObjeto("Combustivel", dados);


    }

    public List<Combustivel> getListaDeDados() {

        return listarDados();
    }

    public void limpar() {
        dadosPreferences.clear();
        dadosPreferences.apply();

    }



}
