package com.ifts.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ifts.bfastfattorino.ModelAPP.PosizioneFattorino;

public class PosizioneFattorinoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "PosizioneFattorino";
    public static final String KEY_POSX = "PosX";
    public static final String KEY_POSY = "PosY";
    public static final String KEY_ID = "id";

    public void PosizioneFattorinoDBAdapter(Context context) {
        this.context = context;
    }
    public PosizioneFattorinoDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(String PosX, String PosY) {
        ContentValues values = new ContentValues();
        values.put(KEY_POSX,PosX);
        values.put(KEY_POSY,PosY);
        return values;
    }

    public long addConnessione (String PosX,String PosY) {
        ContentValues values = createContentValues(PosX,PosY);
        return database.insertOrThrow("PosizioneFattorino", null, values);
    }

    public boolean deleteConnessione(Integer id) {
        return database.delete("PosizioneFattorino", KEY_ID + "=" + id, null) >0;
    }
}
