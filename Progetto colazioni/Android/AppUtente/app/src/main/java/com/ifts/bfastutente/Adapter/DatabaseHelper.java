package com.ifts.bfastutente.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE = "create table Utente (email text primary key , nome text not null unique, " +
            "password text not null, cognome text not null, telefono int not null,nascita Date not null);";
    private static final String DB_CREATE2 = "create table Ordine (id int primary key autoincrement, orario text not null unique, " +
            "note text not null, data Date not null, confermato bit not null,valutazioneFatt float not null," +
            " FOREIGN KEY (\"+idUser+\") REFERENCES \"+Utente+\"(\"+email+\"), FOREIGN KEY (\"+idBar+\") REFERENCES \"+Bar+\"(\"+id+\"));";
    private static final String DB_CREATE3 = "create table Domanda (id integer primary key autoincrement, testo text not null unique);";
    private static final String DB_CREATE4 = "create table Risposta (id integer primary key autoincrement, testo text not null unique);";


    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        db.execSQL(DB_CREATE2);
        db.execSQL(DB_CREATE3);
        db.execSQL(DB_CREATE4);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utente");
        db.execSQL("DROP TABLE IF EXISTS Ordine");
        db.execSQL("DROP TABLE IF EXISTS Domanda");
        db.execSQL("DROP TABLE IF EXISTS Risposta");
        onCreate(db);
    }



}
