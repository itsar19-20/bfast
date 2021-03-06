package com.example.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class RispostaAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Risposta";
    public static final String KEY_TESTO = "testo";
    public static final String KEY_ID = "id";

    public void RispostaDBAdapter(Context context) {
        this.context = context;
    }

    public RispostaAdapter open() throws SQLException {
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

    public long addRisposta (String testo) {
        ContentValues values = createContentValues(testo);
        return database.insertOrThrow("user", null, values);
    }

    public boolean deleteRisposta(Integer id) {
        return database.delete("user", KEY_ID + "=" + id, null) >0;
    }

    public Cursor getRisposta(Integer id) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_ID},
                KEY_ID + "= '" + id + "'", null, null, null, null, null);
        return cursor;
    }
}
