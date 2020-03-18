package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

public class pswDimenticata extends AppCompatActivity {
    public Utente cambio(String mail, String password, String Copassword) {

        Utente _return = null;
        UserDBAdapter udba = new UserDBAdapter(this);
        _return = (Utente) udba.getUserLogin(mail);
        if (password.equals(Copassword)) {
            udba.open();
            udba.updateUser(_return.getEmail(),password,_return.getNome(),_return.getCognome(),_return.getTelefono(),_return.getNascita());
            udba.close();
        }
        return _return;
    }
}
