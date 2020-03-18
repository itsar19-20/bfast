package com.ifts.bfastutente.Business;


import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

public class CambioMail extends AppCompatActivity {
    UserDBAdapter udba = new UserDBAdapter(this);
    public Utente cambio(String mail, String Comail) {
        Utente _return = null;
        _return = (Utente) udba.getUserLogin(mail);
        if (mail.equals(Comail)) {
            _return.setEmail(mail);
            udba.open();
            udba.updateUser(_return.getEmail(),_return.getPass(),_return.getNome(),_return.getCognome(),_return.getTelefono(),_return.getNascita());
            udba.close();
        }
        return _return;
    }
}