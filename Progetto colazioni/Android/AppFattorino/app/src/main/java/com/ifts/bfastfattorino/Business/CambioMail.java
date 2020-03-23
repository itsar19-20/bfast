package com.ifts.bfastfattorino.Business;


import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class CambioMail extends AppCompatActivity {
    private SessionFat session;
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    public Fattorino cambio(String mail, String Comail) {
        Integer id = session.getIDfatt();
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);
        if (mail.equals(Comail)) {
            _return.setMail(mail);
            udba.open();
            udba.updateUser(_return.getMail(),_return.getPassword(),_return.getNome(),_return.getCognome(),_return.getId(),_return.getNascità());
            udba.close();
        }
        return _return;
    }
}