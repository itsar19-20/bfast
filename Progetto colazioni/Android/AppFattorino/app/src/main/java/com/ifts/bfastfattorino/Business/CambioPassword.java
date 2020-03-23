package com.ifts.bfastfattorino.Business;


import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class CambioPassword extends AppCompatActivity {
    private SessionFat session;
    public Fattorino cambio(int s, String password, String Copassword) {
        Integer id = session.getIDfatt();
        FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);

        if (password.equals(Copassword)) {
            _return.setPassword(password);
            udba.open();
            udba.updateUser(_return.getMail(),_return.getPassword(),_return.getNome(),_return.getCognome(),_return.getId(),_return.getNascità());
            udba.close();
        }
        return _return;
    }

}
