package com.ifts.bfastutente.Adapter;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ProdottoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Prodotto";
    public static final String KEY_ID = "id";
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
}
