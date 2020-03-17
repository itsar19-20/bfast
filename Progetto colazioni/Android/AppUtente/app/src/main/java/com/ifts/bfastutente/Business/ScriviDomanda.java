package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.DomandaDBAdapter;
import com.ifts.bfastutente.ModelAPP.Domanda;

import java.text.ParseException;

public class ScriviDomanda extends AppCompatActivity {


    public Domanda registrazione  (String testo) throws ParseException
    {
        DomandaDBAdapter ddb = new DomandaDBAdapter();
        Domanda _return = null;
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