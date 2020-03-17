package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BarDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Ordine";
    public static final String KEY_ID = "id";
    public static final String KEY_NOME = " nome";
    public static final String KEY_DATA = "data";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_VALUTAZIONE = "valutazione";

    public BarDBAdapter (Context context) {
        this.context = context;
    }

    public BarDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(String mail, String password, String nome, String cognome, String telefono, String nascita) {
        ContentValues values = new ContentValues();
        values.put(KEY_MAIL, mail);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_NOME, nome);
        values.put(KEY_COGNOME, cognome);
        values.put(KEY_TELEFONO, telefono);
        values.put(KEY_NASCITA, nascita);
        return values;
    }

    public long addBar (String mail, String password, String nome, String cognome,String telefono,String nascita) {
        ContentValues values = createContentValues(mail, password, nome, cognome,telefono,nascita);
        return database.insertOrThrow("user", null, values);
    }
}
