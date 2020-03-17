package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.ContieneDBAdapter;
import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Contiene;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Prodotto;

public class Prodotti extends AppCompatActivity {

    public Contiene selezione(int id, String prodotto, String quantità){
        ProdottoDBAdapter pdb = new ProdottoDBAdapter();
        Contiene c = null;
        Prodotto _return = null;
        _return = (Prodotto) pdb.getProdottoLogin(prodotto);
        if(_return != null) {
            Ordine o = corrente(id);
            c = Inserimento(o,quantità,_return);
        }
        return c;
    }

    public Contiene Inserimento(Ordine o,String quantità,Prodotto _return) {
        ContieneDBAdapter cdb = new ContieneDBAdapter();
        Contiene c = new Contiene();
        c.setIdOrdine(o.getId());
        c.setIdProdotto(_return.getNome());
        int Quantita=0;
        Quantita = Integer.parseInt(quantità);
        c.setQuantita(Quantita);
        cdb.open();
        cdb.addConnessione(o.getId(),_return.getNome());
        cdb.close();
        return c;
    }

    public Ordine corrente(int id) {
        OrdineDBAdapter odb = new OrdineDBAdapter(this);
        Ordine _return = null;
        _return = (Ordine) odb.getOrdineLogin(id);
        return _return;
    }

}