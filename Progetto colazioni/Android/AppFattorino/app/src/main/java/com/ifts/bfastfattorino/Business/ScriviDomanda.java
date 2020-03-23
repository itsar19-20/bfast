package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.ifts.bfastfattorino.Adapter.DomandaDBAdapter;
import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

import retrofit2.http.Query;

public class ScriviDomanda extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SessionFat session;
    private SQLiteDatabase db;

    public Domanda registrazione  (String testo)
    {
        Integer id = session.getIDfatt();
        DomandaDBAdapter ddb = new DomandaDBAdapter();
        Domanda _return = null;
        _return= (Domanda) udba.getUserLogin(id);

        Cursor ris = db.rawQuery("SELECT d.ID FROM Domanda as d WHERE d.domanda ="+testo,null);

        if (ris==null) {
            _return = new Domanda();
            _return.setDomanda(testo);

            return _return;
        }else {
          //  _return =em.find(Domanda.class, Ris.getFirstResult());
            return _return;
        }
    }



}