package com.ifts.bfastutente.Adapter;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class PagamentoDBAdapter {
    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Pagamento";
    public static final String KEY_ID = "id";
    public static final String KEY_TIPO = " tipo";


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

    private ContentValues createContentValues(String tipo) {
        ContentValues values = new ContentValues();
        values.put(KEY_TIPO, tipo);
        return values;
    }

    public long addPagamento (String tipo) {
        ContentValues values = createContentValues(tipo);
        return database.insertOrThrow("Pagamento", null, values);
    }

    public Cursor getPagamento(int pagamento) {
        Cursor cursor = database.query(true, "user", new String[] {KEY_ID},
                KEY_ID + "= '" + pagamento + "'", null, null, null, null, null);
        return cursor;
    }
}
