package com.ifts.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class DomandaDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Domanda";
    public static final String KEY_TESTO = "testo";
    public static final String KEY_ID = "id";

    public void DomandaDBAdapter(Context context) {
        this.context = context;
    }
    public DomandaDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }

    private ContentValues createContentValues(String testo) {
        ContentValues values = new ContentValues();
        values.put(KEY_TESTO, testo);
        return values;
    }

    public long addUser (String testo) {
        ContentValues values = createContentValues(testo);
        return database.insertOrThrow("user", null, values);
    }

    public boolean deleteFattorino(Integer id) {
        return database.delete("user", KEY_ID + "=" + id, null) >0;
    }
}