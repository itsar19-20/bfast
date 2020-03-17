package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

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

    private ContentValues createContentValues(String ingrediente, String costo, String tipo) {
        ContentValues values = new ContentValues();
        values.put(KEY_INGREDIENTE, ingrediente);
        values.put(KEY_COSTO, costo);
        values.put(KEY_TIPO, tipo);
        return values;
    }

    public long addBar (String ingrediente, String costo, String tipo) {
        ContentValues values = createContentValues(ingrediente, costo, tipo);
        return database.insertOrThrow("Bar", null, values);
    }

    public Cursor getProdottoLogin(String nome) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_NOME},
                KEY_NOME + "= '" + nome + "'", null, null, null, null, null);
        return cursor;
    }


    public boolean updateBar(String nome,String ingrediente, String costo, String tipo) {
        ContentValues updatevalues = createContentValues(ingrediente, costo, tipo);
        return database.update("user", updatevalues, KEY_NOME + "=" + nome, null) > 0;
    }

}
