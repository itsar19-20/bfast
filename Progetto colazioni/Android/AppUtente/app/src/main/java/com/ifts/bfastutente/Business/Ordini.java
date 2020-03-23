package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionBar;
import com.ifts.bfastutente.Sessioni.SessionOrdine;
import com.ifts.bfastutente.Sessioni.SessionUte;

public class Ordini extends AppCompatActivity {

        private SessionUte session;
    private SessionBar session2;
    private SessionOrdine session3;
    public Ordine creazione() {
            String mail = session.getMailUt();
            Ordine o = new Ordine();
            Utente u = null;
            UserDBAdapter udba = new UserDBAdapter(this);
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            u = (Utente) udba.getUserLogin(mail);
            odb.addUser(u.getEmail());
            return o;
        }

        public Ordine bar() {
            Ordine o = null;
            Bar b = null;
            int ido = session3.getIDOrd();
            int idb = session2.getIDBar();
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            //cerca bar e ordine
            odb.addBar(b.getId());
            return o;
        }

        public Ordine carrello(String orario,String Note) {
            int ido = session3.getIDOrd();
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            Ordine o = null;
            //cerca ordine
            odb.open();
            odb.finecarrello(Note,orario);
            odb.close();
            return o;
        }


    }

