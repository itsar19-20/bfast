package com.ifts.bfastfattorino.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.Adapter.PossiedeDBAdapter;
import com.ifts.bfastfattorino.Adapter.RispostaDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Possiede;
import com.ifts.bfastfattorino.ModelAPP.Risposta;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class ScriviRisposta extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SQLiteDatabase db;
    private SessionFat session;

    public Risposta registrazione(int domanda, String testo) {
        Integer id = session.getIDfatt();
        Risposta _return = null;
        _return= (Risposta) udba.getUserLogin(id);
        RispostaDBAdapter rba = new RispostaDBAdapter();

        Cursor ris = db.rawQuery("SELECT r.ID FROM Risposta as r WHERE r.Risposta =" +testo,null);
        if (ris == null) {
            _return = new Risposta();
            _return.setRisposta(testo);

            return _return;
        }else {
           _return = (Risposta) rba.getRisposta(ris.getInt(0));
            return _return;
        }
    }

    private void scrivi(int domanda,Risposta _return) {
         PossiedeDBAdapter pdb= new PossiedeDBAdapter();
         Possiede p = new Possiede();
         Domanda d = new Domanda();
         p.setIdDomanda(domanda);
         p.setIdRisposta(_return.getId());
         pdb.open();
         pdb.addConnessione(d.getDomanda(),_return.getRisposta());
         pdb.close();
    }
}

