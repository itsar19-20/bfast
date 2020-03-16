package com.ifts.bfastutente.Business;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

    public class CambioPassword {

        UserDBAdapter udba = new UserDBAdapter(this);
        public Utente cambio(String mail,String password, String Copassword) {
            Utente _return = null;
            if (password.equals(Copassword)) {
                _return.setPass(password);
                udba.open();
                udba.updateUser(_return.getEmail(),_return.getPass(),_return.getNome(),_return.getCognome(),_return.getTelefono(),_return.getNascita());
                udba.close();
            }
            return _return;
        }


    }


