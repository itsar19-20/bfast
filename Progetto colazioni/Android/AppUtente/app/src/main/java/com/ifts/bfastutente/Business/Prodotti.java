package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.ContieneDBAdapter;
import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Contiene;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.Sessioni.SessionOrdine;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Prodotti extends AppCompatActivity {

    private SessionOrdine session3;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    final ContieneDBAdapter cdb = new ContieneDBAdapter();
    public Contiene selezione(String prodotto, final int quantità){
        ProdottoDBAdapter pdb = new ProdottoDBAdapter();
        Contiene c = null;
        Prodotto _return = null;
        _return = (Prodotto) pdb.getProdottoLogin(prodotto);
        if(_return != null) {
            final Ordine o = corrente(session3.getIDOrd());
            c = Inserimento(o,quantità,_return);
            Call<Contiene> call = apiService.SelezioneProdotto(o.getId(),_return.getNome(),quantità);
            final Prodotto final_return = _return;
            call.enqueue(new Callback<Contiene>() {
                             @Override
                             public void onResponse(Call<Contiene> call, Response<Contiene> response) {
                                 cdb.open();
                                 cdb.addConnessione(o.getId(), final_return.getNome(),quantità);
                                 cdb.close();
                             }

                             @Override
                             public void onFailure(Call<Contiene> call, Throwable t) {

                             }
                         });

        }
        return c;
    }

    public Contiene Inserimento(Ordine o,int quantità,Prodotto _return) {
        Contiene c = new Contiene();
        c.setIdOrdine(o.getId());
        c.setIdProdotto(_return.getNome());
        c.setQuantita(quantità);
        return c;
    }

    public Ordine corrente(int id) {
        OrdineDBAdapter odb = new OrdineDBAdapter(this);
        Ordine _return = null;
        _return = (Ordine) odb.getOrdineLogin(id);
        return _return;
    }

}