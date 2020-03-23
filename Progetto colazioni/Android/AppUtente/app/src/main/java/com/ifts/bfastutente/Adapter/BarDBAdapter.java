package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class BarDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Ordine";
    public static final String KEY_ID = "id";
    public static final String KEY_NOME = " nome";
    public static final String KEY_FASCIA = "fascia";
    public static final String KEY_MAIL = "email";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_VALUTAZIONE = "valutazione";
    public static final String KEY_APERTURA = "oraApe";
    public static final String KEY_CHIUSURA = "oraChi";


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
    private ContentValues createContentValues(String mail, String password, String nome, String valutazioni, String ape, String chi,String fascia) {
        ContentValues values = new ContentValues();
        values.put(KEY_VALUTAZIONE, valutazioni);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_NOME, nome);
        values.put(KEY_MAIL, mail);
        values.put(KEY_APERTURA, ape);
        values.put(KEY_CHIUSURA, chi);
        values.put(KEY_FASCIA, fascia);
        return values;
    }

    public long addBar (String mail, String password, String nome, String valutazioni, String ape, String chi,String fascia) {
        ContentValues values = createContentValues(mail, password, nome, valutazioni,ape,chi,fascia);
        return database.insertOrThrow("Bar", null, values);
    }

    public Cursor getBarLogin(int id ) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_MAIL, KEY_PASSWORD},
                KEY_MAIL + "= '" + id + "'", null, null, null, null, null);
        return cursor;
    }


    public boolean updateBar(String mail, String password, String nome, String valutazioni, String ape, String chi,String fascia) {
        ContentValues updatevalues = createContentValues(mail, password, nome, valutazioni,ape,chi,fascia);
        return database.update("user", updatevalues, KEY_MAIL + "=" + mail, null) > 0;
    }

}
