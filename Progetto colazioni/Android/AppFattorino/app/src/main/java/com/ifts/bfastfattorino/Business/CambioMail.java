package com.ifts.bfastfattorino.Business;


import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;

public class CambioMail {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    public Fattorino cambio(String mail, String Comail) {
        Fattorino _return = null;
        //fattorino corrente
        if (mail.equals(Comail)) {
            _return.setMail(mail);
            udba.open();
            udba.updateUser(_return.getMail(),_return.getPassword(),_return.getNome(),_return.getCognome(),_return.getId(),_return.getNascità());
            udba.close();
        }
        return _return;
    }
}