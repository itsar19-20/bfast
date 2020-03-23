package com.ifts.bfastutente.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.DomandaDBAdapter;
import com.ifts.bfastutente.ModelAPP.Domanda;

import java.text.ParseException;

public class ScriviDomanda extends AppCompatActivity {
    private SQLiteDatabase db;

    public Domanda registrazione  (String testo) throws ParseException
    {

        DomandaDBAdapter ddb = new DomandaDBAdapter();
        Domanda _return = null;
        Cursor ris = db.rawQuery("SELECT d.ID FROM Domanda as d WHERE d.domanda ="+testo,null);

        if (ris == null) {
            _return = new Domanda();
            _return.setDomanda(testo);

            return _return;
        }else {
            _return = (Domanda) ddb.getRisposta(ris.getColumnIndex(String.valueOf(0)));
            return _return;
        }
    }



}