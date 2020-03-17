package com.ifts.bfastutente.Business;

import com.ifts.bfastutente.ModelAPP.Contiene;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Prodotto;

public class Prodotti {

    public Contiene selezione(int id, String prodotto, String quantità){
        Contiene c = null;
        Prodotto _return = null;
        //_return = em.find(Prodotto.class, prodotto);
        if(_return != null) {
          /*  Ordine o = corrente(em,id);
            c = Inserimento(em,o,quantità,_return);*/
        }
        return c;
    }

    public Contiene Inserimento(Ordine o,String quantità,Prodotto _return) {
        Contiene c = new Contiene();
       /* c.setOrdine(o);
        c.setProdotto(_return);*/
        int Quantita=0;
        Quantita = Integer.parseInt(quantità);
        c.setQuantita(Quantita);

        return c;
    }

    public Ordine corrente(int id) {
        Ordine _return = null;
        //_return = em.find(Ordine.class, id);
        return _return;
    }

}