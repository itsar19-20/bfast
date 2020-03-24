package com.ifts.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class IndirizzoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Indirizzo";
    public static final String KEY_ID = "id";
    public static final String KEY_VIA = "via";
    public static final String KEY_CIVICO = " civico";
    public static final String KEY_CAP= "cap";
    public static final String KEY_CITTA = "citta";

    public void IndirizzoDBAdapter(Context context) {
        this.context = context;
    }
    public IndirizzoDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }

    private ContentValues createContentValues(String via, String civico, String citta,String cap) {
        ContentValues values = new ContentValues();
        values.put(KEY_VIA, via);
        values.put(KEY_CIVICO, civico);
        values.put(KEY_CITTA, citta);
        values.put(KEY_CAP,cap);
        return values;
    }

    public long addIndirizzo (String via, String civico, String citta,String cap) {
        ContentValues values = createContentValues(via,civico,citta,cap);
        return database.insertOrThrow("Indirizzo", null, values);
    }

    public boolean deleteIndirizzo(int id) {
        return database.delete("Indirizzo", KEY_ID + "= '" + id + "'", null) >0;
    }


}
