package com.example.bfastutente.Adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "b_fast.db";
    private static final int DB_VERSION = 1;
    private static final String DB_CREATE = "create table Utente (email text primary key , nome text not null unique, " +
            "password text not null, cognome text not null, telefono int not null,nascita Date not null);";
    private static final String DB_CREATE2 = "create table Ordine (id Integer primary key autoincrement, orario text not null unique, " +
            "note text not null, data Date not null, confermato int not null,valutazioneFatt float not null," +
            "idUser text not null, idBar int not null,idTipoPagamento int not null," +
            "FOREIGN KEY (\"idUser\") REFERENCES \"Utente\"(\"email\"), FOREIGN KEY (\"idBar\") REFERENCES \"+Bar+\"(\"id\")," +
            "FOREIGN KEY (\"idTipoPagamento\") REFERENCES \"+Pagamento+\"(\"+id+\"));";
    private static final String DB_CREATE3 = "create table Domanda (id integer primary key autoincrement, testo text not null unique);";
    private static final String DB_CREATE4 = "create table Risposta (id integer primary key autoincrement, testo text not null unique);";
    private static final String DB_CREATE5 = "create table Bar (id integer primary key autoincrement, nome text not null unique, " +
            "password text not null, orarioApe text not null,orarioChi text not null, fascia float not null,valutazione float not null," +
            "email text not null,idIndirizzo int not null," +
            "FOREIGN KEY(\"idIndirizzo\") REFERENCES \"+Indirizzo+\"(\"+id+\"));";
    private static final String DB_CREATE6 = "create table Possiede (id integer primary key autoincrement,idDom int not null,idRis int not null," +
            "FOREIGN KEY(\"idDom\") REFERENCES \"+Domanda+\"(\"+id+\"), FOREIGN KEY(\"idRis\") REFERENCES \"+Risposta+\"(\"+id+\"));";
    private static final String DB_CREATE7 = "create table Contiene (id integer primary key autoincrement,idOrd int not null,idPro int not null," +
            "FOREIGN KEY(\"idOrd\") REFERENCES \"+Ordine+\"(\"+id+\"), FOREIGN KEY(\"idPro\") REFERENCES \"+Prodotto+\"(\"+id+\"));";
    private static final String DB_CREATE8 = "create table Prodotto (nome text primary key ," +
            "ingrediente text not null, costo float not null,tipo text not null);";
    private static final String DB_CREATE9 = "create table Indirizzo (id integer primary key autoincrement,x double not null ," +
            "y double not null);";
    private static final String DB_CREATE10 = "create table Pagamento (id Integer primary key autoincrement, tipo text not null unique);";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DB_CREATE);
        db.execSQL(DB_CREATE2);
        db.execSQL(DB_CREATE8);
        db.execSQL(DB_CREATE3);
        db.execSQL(DB_CREATE4);
        db.execSQL(DB_CREATE5);
        db.execSQL(DB_CREATE6);
        db.execSQL(DB_CREATE7);
        db.execSQL(DB_CREATE9);
        db.execSQL(DB_CREATE10);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Utente");
        db.execSQL("DROP TABLE IF EXISTS Ordine");
        db.execSQL("DROP TABLE IF EXISTS Prodotto");
        db.execSQL("DROP TABLE IF EXISTS Domanda");
        db.execSQL("DROP TABLE IF EXISTS Risposta");
        db.execSQL("DROP TABLE IF EXISTS Bar");
        db.execSQL("DROP TABLE IF EXISTS Possiede");
        db.execSQL("DROP TABLE IF EXISTS Contiene");
        db.execSQL("DROP TABLE IF EXISTS Indirizzo");
        db.execSQL("DROP TABLE IF EXISTS Pagamento");
        onCreate(db);
    }



}
