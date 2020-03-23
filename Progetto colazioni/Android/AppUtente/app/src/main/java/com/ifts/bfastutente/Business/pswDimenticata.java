package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionUte;

public class pswDimenticata extends AppCompatActivity {
    private SessionUte session;
    public Utente cambio(String password, String Copassword) {
        String mail = session.getMailUt();
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
