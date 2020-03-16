package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Ordine;

    public class Ordini extends AppCompatActivity {


        public Ordine creazione(String idu) {
            Ordine o = new Ordine();
            UserDBAdapter udba = new UserDBAdapter(this);
            //cerca utente
            return o;
        }

        public Ordine bar(int ido,int idb) {
            Ordine o = null;
            //cerca bar e ordine
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

