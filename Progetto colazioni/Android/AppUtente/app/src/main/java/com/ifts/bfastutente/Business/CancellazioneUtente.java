package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.Session;

public class CancellazioneUtente extends AppCompatActivity {

        public Utente login() {
            String mail = Session.getMailUt();
            Utente _return = null;
            UserDBAdapter udba = new UserDBAdapter(this);
            _return = (Utente) udba.getUserLogin(mail);
            if (_return != null) {
               udba.open();
               udba.deleteUserByUsername(_return.getEmail());
               udba.close();
            }
            return _return;
        }

    }

