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
    public static final String KEY_X = "x";
    public static final String KEY_Y = " y";;

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

    private ContentValues createContentValues(double x, double y) {
        ContentValues values = new ContentValues();
        values.put(KEY_X, x);
        values.put(KEY_Y, y);
        return values;
    }

    public long addIndirizzo (double x, double y) {
        ContentValues values = createContentValues(x,y);
        return database.insertOrThrow("Indirizzo", null, values);
    }

    public boolean deleteIndirizzo(int id) {
        return database.delete("Indirizzo", KEY_ID + "= '" + id + "'", null) >0;
    }


}
