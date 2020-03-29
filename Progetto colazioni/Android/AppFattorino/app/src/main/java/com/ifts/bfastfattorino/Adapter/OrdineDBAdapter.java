package com.ifts.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public static final String KEY_UTENTE = "idUser";
    public static final String KEY_BAR = "idBar";
    public static final String KEY_PAGAMENTO = "pagamento";
    public static final String KEY_FATTORINO = "fattorino";

    public OrdineDBAdapter(Context context) {
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

    private ContentValues createContentValuesFattorino(int id) {
        ContentValues values = new ContentValues();
        values.put(KEY_FATTORINO,id);
        return values;
    }

    public long CreazioneFattorino(int id ){
        ContentValues values = createContentValuesFattorino(id);
        return database.insertOrThrow("Ordine", null, values);
    }

    public Cursor getOrdineLogin(Integer id) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_ID},
                KEY_ID + "= '" + id + "'", null, null, null, null, null);
        return cursor;
    }



}
