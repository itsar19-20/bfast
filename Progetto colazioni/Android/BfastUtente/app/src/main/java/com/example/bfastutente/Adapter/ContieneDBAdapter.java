package com.example.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class ContieneDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Possiede";
    public static final String KEY_ORDINE = "idOrd";
    public static final String KEY_PRODOTTO = "idPro";
    public static final String KEY_ID = "id";
    public static final String KEY_QUANTITA= "quantita";

    public void ContieneDBAdapter(Context context) {
        this.context = context;
    }
    public ContieneDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(int ordine, String prodotto,int quantita) {
        ContentValues values = new ContentValues();
        values.put(KEY_ORDINE,ordine);
        values.put(KEY_PRODOTTO,prodotto);
        values.put(KEY_QUANTITA,quantita);
        return values;
    }

    public long addConnessione (int ordine,String prodotto,int quantita) {
        ContentValues values = createContentValues(ordine,prodotto,quantita);
        return database.insertOrThrow("Possiede", null, values);
    }

    public boolean deleteConnessione(Integer id) {
        return database.delete("Possiede", KEY_ID + "=" + id, null) >0;
    }
}
