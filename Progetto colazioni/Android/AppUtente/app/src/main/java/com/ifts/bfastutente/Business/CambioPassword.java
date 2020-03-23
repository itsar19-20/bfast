package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionUte;

public class CambioPassword extends AppCompatActivity {
        private SessionUte session;
        UserDBAdapter udba = new UserDBAdapter(this);
        public Utente cambio(String password, String Copassword) {
            String mail = session.getMailUt();
            Utente _return = null;
            _return = (Utente) udba.getUserLogin(mail);
            if (password.equals(Copassword)) {
                _return.setPass(password);
                udba.open();
                udba.updateUser(_return.getEmail(),_return.getPass(),_return.getNome(),_return.getCognome(),_return.getTelefono(),_return.getNascita());
                udba.close();
            }
            return _return;
        }


    }


