package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;

public class pswDimenticata extends AppCompatActivity {

    public Fattorino cambio(int s, String password, String Copassword) {

        Fattorino _return = null;
        FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        // cerca utente
        if (password.equals(Copassword)) {
            udba.open();
            udba.updateUser(_return.getMail(),password,_return.getNome(),_return.getCognome(),_return.getId(),_return.getNascità());
            udba.close();
        }
        return _return;
    }

}