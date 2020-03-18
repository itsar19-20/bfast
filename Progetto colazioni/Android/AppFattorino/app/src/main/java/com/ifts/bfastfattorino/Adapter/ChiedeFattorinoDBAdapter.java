package com.ifts.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ifts.bfastfattorino.ModelAPP.ChiedeFattorino;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;

public class ChiedeFattorinoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "ChiedeFattorino";
    public static final String KEY_FATTORINO = "idFat";
    public static final String KEY_DOMANDA = "idDom";
    public static final String KEY_ID = "id";

    public void ChiedeFattorinoDBAdapter(Context context) {
        this.context = context;
    }
    public ChiedeFattorinoDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(String Domanda, String Fattorino) {
        ContentValues values = new ContentValues();
        values.put(KEY_FATTORINO, Fattorino);
        values.put(KEY_DOMANDA,Domanda);
        return values;
    }

    public long addConnessione (String Domanda,String Fattorino) {
        ContentValues values = createContentValues(Domanda,Fattorino);
        return database.insertOrThrow("ChiedeFattorino", null, values);
    }

    public boolean deleteConnessione(Integer id) {
        return database.delete("ChiedeFattorino", KEY_ID + "=" + id, null) >0;
    }
}
