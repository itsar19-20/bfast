package com.ifts.bfastfattorino.Business;


import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class CancellazioneFattorino extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);

    public Fattorino canc() {
        Integer id = SessionFat.getIDfatt();
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);

        FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        //cerca fattorino
        if (_return != null) {
            udba.open();
            udba.deleteFattorino(_return.getId());
            udba.close();
        }
        return _return;
    }

}
