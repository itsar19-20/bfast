package com.ifts.bfastutente.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class BarDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Ordine";
    public static final String KEY_ID = "id";
    public static final String KEY_NOTE = " note";
    public static final String KEY_DATA = "data";
    public static final String KEY_CONFERMATO = "confermato";
    public static final String KEY_VALUTAZIONE = "valutazione";
}
