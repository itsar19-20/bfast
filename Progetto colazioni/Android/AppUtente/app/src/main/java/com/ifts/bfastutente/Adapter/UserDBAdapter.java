package com.ifts.bfastutente.Adapter;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.ifts.bfastutente.Business.CancellazioneUtente;

public class UserDBAdapter {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "Utente";
    public static final String KEY_MAIL = "mail";
    public static final String KEY_TELEFONO = "telefono";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NOME = "nome";
    public static final String KEY_COGNOME = "cognome";
    public static final String KEY_NASCITA = "nascita";

    public UserDBAdapter (Context context) {
        this.context = context;
    }

    public UserDBAdapter open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }
    public void close() {
        dbHelper.close();
        database.close();
    }
    private ContentValues createContentValues(String mail, String password, String nome, String cognome,String telefono,String nascita) {
        ContentValues values = new ContentValues();
        values.put(KEY_MAIL, mail);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_NOME, nome);
        values.put(KEY_COGNOME, cognome);
        values.put(KEY_TELEFONO, telefono);
        values.put(KEY_NASCITA, nascita);
        return values;
    }

    public long addUser (String mail, String password, String nome, String cognome,String telefono,String nascita) {
        ContentValues values = createContentValues(mail, password, nome, cognome,telefono,nascita);
        return database.insertOrThrow("user", null, values);
    }

    public Cursor getUserLogin(String mail) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_MAIL, KEY_PASSWORD},
                KEY_MAIL + "= '" + mail + "'", null, null, null, null, null);
        return cursor;
    }


    public boolean updateUser(String mail, String password, String nome, String cognome, int telefono, long nascita) {
        String tel = Integer.toString(telefono);
        String nas = Integer.toString((int) nascita);
        ContentValues updateValues = createContentValues(mail, password, nome, cognome,tel,nas);
        return database.update("user", updateValues, KEY_MAIL + "=" + mail, null) > 0;
    }

    public boolean deleteUserByUsername(String s) {
        return database.delete("user", KEY_MAIL + "= '" + s + "'", null) >0;
    }

    public Cursor fetchUsers() {
        return database.query("user", new String[]
                        {KEY_MAIL, KEY_NOME, KEY_PASSWORD, KEY_COGNOME, KEY_TELEFONO,KEY_NASCITA},
                null, null, null, null, null);
    }

}
