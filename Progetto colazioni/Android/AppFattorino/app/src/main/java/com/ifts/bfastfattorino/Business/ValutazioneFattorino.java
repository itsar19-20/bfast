package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;

public class ValutazioneFattorino extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);

    public String valutazione(Integer s) {

        Fattorino f = cerca(s);
        String Ris = ("SELECT AVG(o.ValutazioneFatt) FROM `ordine` as o,fattorino as f"
                + "WHERE o.IDfaFK = f.ID" +
                "")/*.setParameter("f.ID", f.getId())*/;
        return Ris;
    }

    public Fattorino cerca (Integer id) {

        Fattorino _return = new Fattorino();
        _return= (Fattorino) udba.getUserLogin(id);
        return _return;
    }
}