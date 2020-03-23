package com.ifts.bfastutente.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.PossiedeDBAdapter;
import com.ifts.bfastutente.Adapter.RispostaAdapter;
import com.ifts.bfastutente.ModelAPP.Domanda;
import com.ifts.bfastutente.ModelAPP.Possiede;
import com.ifts.bfastutente.ModelAPP.Risposta;

public class ScriviRisposta extends AppCompatActivity {
    private SQLiteDatabase db;

    public Risposta registrazione(int domanda, String testo) {
        Risposta _return = null;
        RispostaAdapter rba = new RispostaAdapter();

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

    private void scrivi(int domanda, Risposta _return) {
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

