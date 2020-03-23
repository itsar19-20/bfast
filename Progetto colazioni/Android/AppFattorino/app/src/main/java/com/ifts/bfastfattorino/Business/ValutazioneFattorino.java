package com.ifts.bfastfattorino.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class ValutazioneFattorino extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SQLiteDatabase db;
    private SessionFat session;
    public Cursor valutazione() {
        Integer id = session.getIDfatt();
        Fattorino f = cerca(id);
        Cursor Ris = db.rawQuery("SELECT AVG(o.ValutazioneFatt) FROM `ordine` as o,fattorino as f WHERE o.IDfaFK ="+f.getId() ,null);
        return Ris;
    }

    public Fattorino cerca (Integer id) {
        Fattorino _return = new Fattorino();
        _return= (Fattorino) udba.getUserLogin(id);
        return _return;
    }
}
