package devandroid.marcell.appgaseta1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import devandroid.marcell.appgaseta1.model.Combustivel;

public class GasEtaDB extends SQLiteOpenHelper {

    private static final String DB_NAME = "gaseta.db";
    private static final int DB_VERSION = 1;

    Cursor cursor;
    SQLiteDatabase db;

    public GasEtaDB(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        db = getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaCombustivel = "CREATE TABLE Combustivel (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "nomeDoCombustivel TEXT, " +
                "precoDoCombustivel REAL, " +
                "recomendacao TEXT)";

        db.execSQL(sqlTabelaCombustivel);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarObjeto(String table, ContentValues dados) {

        db.insert(table, null, dados);
    }

    public List<Combustivel> listarDados() {

        List<Combustivel> lista = new ArrayList<>();
        Combustivel registro;

        String querySql = "SELECT * FROM Combustivel";

        cursor = db.rawQuery(querySql, null);

        if (cursor.moveToFirst()) {
            do {
                registro = new Combustivel();
                registro.setId(cursor.getInt(0));
                registro.setNomeDoCombustivel(cursor.getString(1));
                registro.setPrecoDoCombustivel(cursor.getDouble(2));
                registro.setRecomendacao(cursor.getString(3));

                lista.add(registro);

            } while (cursor.moveToNext());
        }

        return lista;

    }

    public void alterarObjeto(String table, ContentValues dados) {

        int id = dados.getAsInteger("id");

        db.update(table, dados, "id=?", new String[]{Integer.toString(id)});

    }

    public void deletarObjeto(String table, int id) {

        db.delete(table, "id=?", new String[]{Integer.toString(id)});

    }

}
