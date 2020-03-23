package com.ifts.bfastutente.Business;

import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionUte;

public class InserisciValutazione extends AppCompatActivity {
    private SessionUte session;
    private SQLiteDatabase db;
    public void inserisci(float valutazione){
        UserDBAdapter udb = new UserDBAdapter(this);
        OrdineDBAdapter odb = new OrdineDBAdapter(this);
        String mail = session.getMailUt();
        Utente user = (Utente) udb.getUserLogin(mail);
        odb.setValutazioneOrdine(valutazione);
    }

}
