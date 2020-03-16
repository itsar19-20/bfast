package com.ifts.bfastfattorino.Business;


import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;

public class CancellazioneFattorino extends AppCompatActivity {

    public Fattorino canc(int mail) {
        Fattorino _return = null;
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
