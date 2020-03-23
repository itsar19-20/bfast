package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.BarDBAdapter;
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
            session3.setIDOrd(o.getId());
            return o;
        }

        public Ordine bar() {
            int ido = session3.getIDOrd();
            int idb = session2.getIDBar();
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            BarDBAdapter bdb = new BarDBAdapter(this);
            Bar b = (Bar) bdb.getBarLogin(idb);
            Ordine o = (Ordine) odb.getOrdineLogin(ido);
            odb.addBar(b.getId());
            return o;
        }

        public Ordine carrello(String orario,String Note) {
            int ido = session3.getIDOrd();
            OrdineDBAdapter odb = new OrdineDBAdapter(this);
            Ordine o = (Ordine) odb.getOrdineLogin(ido);
            odb.open();
            odb.finecarrello(Note,orario);
            odb.close();
            return o;
        }
    }

