package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.BarDBAdapter;
import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.PagamentoDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Pagamento;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionBar;
import com.ifts.bfastutente.Sessioni.SessionOrdine;
import com.ifts.bfastutente.Sessioni.SessionUte;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ordini extends AppCompatActivity {

    final PagamentoDBAdapter pdb = new PagamentoDBAdapter();
    final OrdineDBAdapter odb = new OrdineDBAdapter(this);
    private SessionUte session;
    private SessionBar session2;
    private SessionOrdine session3;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    public Ordine creazione() {
            String mail = session.getMailUt();
            final Ordine o = new Ordine();
            Utente u = null;
            UserDBAdapter udba = new UserDBAdapter(this);
            final OrdineDBAdapter odb = new OrdineDBAdapter(this);
            u = (Utente) udba.getUserLogin(mail);
            Call<Ordine> call = apiService.ordiniUt(o.getId(),u.getEmail());
            final Utente finalU = u;
            call.enqueue(new Callback<Ordine>() {
                             @Override
                             public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                                 odb.addUser(finalU.getEmail());
                                 session3.setIDOrd(o.getId());
                             }

                             @Override
                             public void onFailure(Call<Ordine> call, Throwable t) {

                             }
                         });
            return o;
        }

        public Ordine bar() {
            int ido = session3.getIDOrd();
            int idb = session2.getIDBar();
            BarDBAdapter bdb = new BarDBAdapter(this);
            final Bar b = (Bar) bdb.getBarLogin(idb);
            Ordine o = (Ordine) odb.getOrdineLogin(ido);
            Call<Ordine> call = apiService.ordiniBa(b.getId());
            call.enqueue(new Callback<Ordine>() {
                             @Override
                             public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                                 odb.open();
                                 odb.addBar(b.getId());
                                 odb.close();
                             }

                             @Override
                             public void onFailure(Call<Ordine> call, Throwable t) {

                             }
                         });
            return o;
        }

        public Ordine carrello(final String orario, int paga, final String Note) {
            int ido = session3.getIDOrd();
            Ordine o = (Ordine) odb.getOrdineLogin(ido);
            final Pagamento p = (Pagamento) pdb.getPagamento(paga);
            Call<Ordine> call = apiService.ordiniCa(orario, paga, Note);
            call.enqueue(new Callback<Ordine>() {
                             @Override
                             public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                                 odb.open();
                                 odb.finecarrello(Note,orario,p.getId());
                                 odb.close();
                             }

                             @Override
                             public void onFailure(Call<Ordine> call, Throwable t) {

                             }
                         });
            return o;
        }
    }

