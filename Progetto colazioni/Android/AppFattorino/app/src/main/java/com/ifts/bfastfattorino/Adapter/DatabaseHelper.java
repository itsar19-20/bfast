package com.ifts.bfastfattorino.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "database.db";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE = "create table Fattorino (id integer primary key autoincrement, nome text not null unique, " +
            "password text not null, cognome text not null, telefono int not null,nascita Date not null);";
    private static final String DB_CREATE2 = "create table Domanda (id integer primary key autoincrement, testo text not null unique);";
    private static final String DB_CREATE3 = "create table Risposta (id integer primary key autoincrement, testo text not null unique);";
    private static final String DB_CREATE4 = "create table Possiede (id integer primary key autoincrement," +
            "FOREIGN KEY(\"+idDom+\") REFERENCES \"+Domanda+\"(\"+id+\"), FOREIGN KEY(\"+idRis+\") REFERENCES \"+Risposta+\"(\"+id+\"));";
    private static final String DB_CREATE5 = "create table ChiedeFattorino (id integer primary key autoincrement," +
            "FOREIGN KEY(\"+idDom+\") REFERENCES \"+Domanda+\"(\"+id+\"), FOREIGN KEY(\"+idFat+\") REFERENCES \"+Fattorino+\"(\"+id+\"));";
    private static final String DB_CREATE6 = "create table Pagamento (id integer primary key autoincrement, Tipo text not null unique);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        db.execSQL(DB_CREATE2);
        db.execSQL(DB_CREATE3);
        db.execSQL(DB_CREATE4);
        db.execSQL(DB_CREATE5);
        db.execSQL(DB_CREATE6);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Fattorino");
        db.execSQL("DROP TABLE IF EXISTS Domanda");
        db.execSQL("DROP TABLE IF EXISTS Risposta");
        db.execSQL("DROP TABLE IF EXISTS Possiede");
        db.execSQL("DROP TABLE IF EXISTS ChiedeFattorino");
        db.execSQL("DROP TABLE IF EXISTS Pagamento");
        onCreate(db);
    }


}
