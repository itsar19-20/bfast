package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class pswDimenticata extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);

    public Fattorino cambio(String password, String Copassword) {
        Integer id = SessionFat.getIDfatt();
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);

        // cerca utente
        if (password.equals(Copassword)) {
            udba.open();
            udba.updateUser(_return.getMail(),password,_return.getNome(),_return.getCognome(),_return.getId(),_return.getNascità());
            udba.close();
        }
        return _return;
    }

}