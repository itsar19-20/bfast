package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.DomandaDBAdapter;
import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Risposta;
import com.ifts.bfastfattorino.Sessioni.Session;

import java.text.ParseException;

public class ScriviDomanda extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);

    public Domanda registrazione  (String testo)
    {
        Integer id = Session.getIDfatt();
        DomandaDBAdapter ddb = new DomandaDBAdapter();
        Domanda _return = null;
        _return= (Domanda) udba.getUserLogin(id);

        String Ris = ("SELECT d.ID FROM Domanda as d \r\n" +
                "WHERE d.domanda = \"testo\";")/*.setParameter("testo", testo)*/;
        if (Ris == null) {
            _return = new Domanda();
            _return.setDomanda(testo);

            return _return;
        }else {
          //  _return =em.find(Domanda.class, Ris.getFirstResult());
            return _return;
        }
    }



}