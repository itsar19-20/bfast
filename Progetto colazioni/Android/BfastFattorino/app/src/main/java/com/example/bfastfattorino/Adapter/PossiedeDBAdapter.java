package com.example.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PossiedeDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Possiede";
    public static final String KEY_RISPOSTA = "idRis";
    public static final String KEY_DOMANDA = "idDom";
    public static final String KEY_ID = "id";

    public void PossiedeDBAdapter(Context context) {
        this.context = context;
    }
    public PossiedeDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(String Domanda,String Risposta) {
        ContentValues values = new ContentValues();
        values.put(KEY_RISPOSTA,Risposta);
        values.put(KEY_DOMANDA,Domanda);
        return values;
    }

    public long addConnessione (String Domanda,String Risposta) {
        ContentValues values = createContentValues(Domanda,Risposta);
        return database.insertOrThrow("Possiede", null, values);
    }

    public boolean deleteConnessione(Integer id) {
        return database.delete("Possiede", KEY_ID + "=" + id, null) >0;
    }
}
