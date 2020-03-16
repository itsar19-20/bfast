package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
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

    private ContentValues createContentValuesUtente(String note, String data, String confermato, String valutazione) {
        ContentValues values = new ContentValues();
        return values;
    }

    public long addUser (String note, String data, String confermato, String valutazione) {
        ContentValues values = createContentValuesUtente(note, data, confermato, valutazione);
        return database.insertOrThrow("Ordine", null, values);
    }



    public long finecarrello(String note,String data){
        ContentValues values = createContentValuesCarrello(note, data);
        return database.insertOrThrow("Ordine", null, values);
    }

}
