package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class OrdineDBAdapter {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Ordine";
    public static final String KEY_ID = "id";
    public static final String KEY_NOTE = " note";
    public static final String KEY_DATA = "data";
    public static final String KEY_CONFERMATO = "confermato";
    public static final String KEY_VALUTAZIONE = "valutazione";
    public static final String KEY_UTENTE = "idUser";
    public static final String KEY_BAR = "idBar";

    public OrdineDBAdapter (Context context) {
        this.context = context;
    }

    public OrdineDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
        database.close();
    }

    private ContentValues createContentValuesCarrello(String note, String data) {
        ContentValues values = new ContentValues();
        values.put(KEY_NOTE, note);
        values.put(KEY_DATA, data);
        return values;
    }

    private ContentValues createContentValuesUtente(String utente) {
        ContentValues values = new ContentValues();
        values.put(KEY_UTENTE, utente);
        return values;
    }
    private ContentValues createContentValuesBar(int bar) {
        ContentValues values = new ContentValues();
        values.put(KEY_BAR, bar);
        return values;
    }

    public long addUser (String utente) {
        ContentValues values = createContentValuesUtente(utente);
        return database.insertOrThrow("Ordine", null, values);
    }

    public long addBar (int note) {
        ContentValues values = createContentValuesBar(note);
        return database.insertOrThrow("Ordine", null, values);
    }

    public long finecarrello(String note,String data){
        ContentValues values = createContentValuesCarrello(note, data);
        return database.insertOrThrow("Ordine", null, values);
    }

    public Cursor getOrdineLogin(Integer id) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_ID},
                KEY_ID + "= '" + id + "'", null, null, null, null, null);
        return cursor;
    }


}
