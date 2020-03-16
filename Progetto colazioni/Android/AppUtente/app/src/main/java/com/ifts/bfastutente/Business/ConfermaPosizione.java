package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.ModelAPP.Indirizzo;

import retrofit2.http.Query;

public class ConfermaPosizione extends AppCompatActivity {

        public int Visualizza(String via,String civico,String cap,String citta) {

            String Ris = ("SELECT i.ID FROM inditizzo as i\r\n" +
            "WHERE i.via = Via AND i.civico = Civico AND i.citta = Citta AND i.CAP = cap");/*.setParameter("Via", via).setParameter("Civico", civico)
            .setParameter("cap", cap).setParameter("Citta", citta).getSingleResult()*/
            if(Ris == null) {
                Indirizzo i = new Indirizzo();
                i.setCap(cap);
                i.setCitta(citta);
                i.setCivico(civico);
                i.setVia(via);
                return i.getId();
            }else {
                int i = Integer.parseInt(Ris);
                return i;
            }
        }
    }
