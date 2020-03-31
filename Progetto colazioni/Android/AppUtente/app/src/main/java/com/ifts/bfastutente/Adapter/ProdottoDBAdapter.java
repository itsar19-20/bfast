package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdottoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Prodotto";
    public static final String KEY_NOME = "nome";
    public static final String KEY_INGREDIENTE = " ingrediente";
    public static final String KEY_COSTO = "costo";
    public static final String KEY_TIPO = "tipo";

    public void ProdottoDBAdapter(Context context) {
        this.context = context;
    }
    public ProdottoDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }

    private ContentValues createContentValues(String nome,String ingrediente, float costo, String tipo) {
        ContentValues values = new ContentValues();
        values.put(KEY_NOME,nome);
        values.put(KEY_INGREDIENTE, ingrediente);
        values.put(KEY_COSTO, costo);
        values.put(KEY_TIPO, tipo);
        return values;
    }

    public long addProdotto (String nome,String ingrediente, float costo, String tipo) {
        ContentValues values = createContentValues(nome,ingrediente, costo, tipo);
        return database.insertOrThrow("Prodotto", null, values);
    }

    public Cursor getProdottoLogin(String nome) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_NOME},
                KEY_NOME + "= '" + nome + "'", null, null, null, null, null);
        return cursor;
    }


    public boolean updateBar(String nome,String ingrediente, float costo, String tipo) {
        ContentValues updatevalues = createContentValues(nome,ingrediente, costo, tipo);
        return database.update("Prodotto", updatevalues, KEY_NOME + "=" + nome, null) > 0;
    }
    public List<String> getIdProdotto() {
        List<String> _return = new ArrayList<>();
        String query = "select Indirizzo.id from Indirizzo,Bar WHERE Bar.IDinFK = indirizzo.ID;";
        Cursor cursor = database.rawQuery(query, null);
        while (cursor.moveToNext()) {
            _return.add(cursor.getString(0));
        }
        return _return;
    }

    public Cursor fetchProdotto() {
        return database.query("Prodotto", new String[]
                        {KEY_NOME, KEY_INGREDIENTE, KEY_COSTO, KEY_TIPO},
                null, null, null, null, null);
    }


}
