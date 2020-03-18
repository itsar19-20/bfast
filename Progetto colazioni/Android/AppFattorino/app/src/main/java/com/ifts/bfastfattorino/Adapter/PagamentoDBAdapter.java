package com.ifts.bfastfattorino.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PagamentoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Pagamento";
    public static final String KEY_ID = "id";
    public static final String KEY_TIPO = "Tipo";


    public void PagamentoDBAdapter(Context context) {
        this.context = context;
    }
    public PagamentoDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(String id, String Tipo) {
        ContentValues values = new ContentValues();
        values.put(KEY_ID, id);
        values.put(KEY_TIPO,Tipo);
        return values;
    }

    public long addConnessione (String id,String Tipo) {
        ContentValues values = createContentValues(id,Tipo);
        return database.insertOrThrow("Pagamento", null, values);
    }

    public boolean deleteConnessione(Integer id) {
        return database.delete("Pagamento", KEY_ID + "=" + id, null) >0;
    }
}
