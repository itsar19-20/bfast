package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

public class CancellazioneUtente extends AppCompatActivity {

        public Utente login(String mail) {
            Utente _return = null;
            UserDBAdapter udba = new UserDBAdapter(this);
           // cerca utente
           if (_return != null) {
               udba.open();
               udba.deleteUserByUsername(_return.getEmail());
               udba.close();
            }
            return _return;
        }

    }

