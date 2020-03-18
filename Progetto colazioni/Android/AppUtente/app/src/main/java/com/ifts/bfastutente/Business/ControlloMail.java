package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;

public class ControlloMail extends AppCompatActivity{
    UserDBAdapter udba = new UserDBAdapter(this);

        public Utente cambio(String mail) {
            Utente _return = null;
                _return = (Utente) udba.getUserLogin("mail");
                return _return;
    }
}