package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.Session;

public class Ordini extends AppCompatActivity {


        public Ordine creazione() {
            String mail = Session.getMailUt();
            Ordine o = new Ordine();
            Utente u = null;
            UserDBAdapter udba = new UserDBAdapter(this);
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            u = (Utente) udba.getUserLogin(mail);
            odb.addUser(u.getEmail());
            return o;
        }

        public Ordine bar(int ido,int idb) {
            Ordine o = null;
            Bar b = null;
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            //cerca bar e ordine
            odb.addBar(b.getId());
            return o;
        }

        public Ordine carrello(int ido,String orario,String Note) {
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            Ordine o = null;
            //cerca ordine
            odb.open();
            odb.finecarrello(Note,orario);
            odb.close();
            return o;
        }


    }

