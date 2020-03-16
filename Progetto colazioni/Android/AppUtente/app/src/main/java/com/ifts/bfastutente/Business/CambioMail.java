package com.ifts.bfastutente.Business;


import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

public class CambioMail {
    UserDBAdapter udba = new UserDBAdapter(this);
    public Utente cambio(String mail, String Comail) {
        Utente _return = null;
        //utente corrente
        if (mail.equals(Comail)) {
            _return.setEmail(mail);
            udba.open();
            udba.updateUser(_return.getEmail(),_return.getPass(),_return.getNome(),_return.getCognome(),_return.getTelefono(),_return.getNascita());
            udba.close();
        }
        return _return;
    }
}