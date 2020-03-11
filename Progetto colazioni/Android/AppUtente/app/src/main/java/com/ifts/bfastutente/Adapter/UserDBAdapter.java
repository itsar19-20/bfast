package com.ifts.bfastutente.Adapter;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class UserDBAdapter {

    private Context context;
    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    public static final String DB_NAME = "user";
    public static final String KEY_USERID = "_id";
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";
    public static final String KEY_NAME = "name";
    public static final String KEY_LASNAME = "lastName";

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
    private ContentValues createContentValues(String username, String password, String nome, String lastName) {
        ContentValues values = new ContentValues();
        values.put(KEY_USERNAME, username);
        values.put(KEY_PASSWORD, password);
        values.put(KEY_NAME, nome);
        values.put(KEY_LASNAME, lastName);
        return values;
    }

    public long addUser (String username, String password, String name, String lastName) {
        ContentValues values = createContentValues(username, password, name, lastName);
        return database.insertOrThrow("user", null, values);
    }

    public Cursor getUserLogin(String username) {
        Cursor cursor = database.query(true, "user", new String[] { KEY_USERNAME, KEY_PASSWORD},
                KEY_USERNAME + "= '" + username + "'", null, null, null, null, null);
        return cursor;
    }


    public boolean updateUser(Integer _id, String username, String password, String name, String lastName) {
        ContentValues updateValues = createContentValues(username, password, name, lastName);
        return database.update("user", updateValues, KEY_USERID + "=" + _id, null) > 0;
    }

    public boolean deleteUserByUsername(String s) {
        return database.delete("user", KEY_USERNAME + "= '" + s + "'", null) >0;
    }

    public boolean deleteUser(Integer id) {
        return database.delete("user", KEY_USERID + "=" + id, null) >0;
    }

    public Cursor fetchUsers() {
        return database.query("user", new String[]
                        {KEY_USERID, KEY_USERNAME, KEY_PASSWORD, KEY_NAME, KEY_LASNAME},
                null, null, null, null, null);
    }


}
