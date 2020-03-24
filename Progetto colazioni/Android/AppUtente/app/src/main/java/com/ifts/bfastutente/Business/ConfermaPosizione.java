package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.ModelAPP.Indirizzo;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfermaPosizione extends AppCompatActivity {

        BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();

        public int Visualizza(final String via, final String civico, final String cap, final String citta) {

            String Ris = ("SELECT i.ID FROM inditizzo as i\r\n" +
            "WHERE i.via = Via AND i.civico = Civico AND i.citta = Citta AND i.CAP = cap");/*.setParameter("Via", via).setParameter("Civico", civico)
            .setParameter("cap", cap).setParameter("Citta", citta).getSingleResult()*/
            if(Ris == null) {
                Indirizzo i = new Indirizzo();
                i.setCap(cap);
                i.setCitta(citta);
                i.setCivico(civico);
                i.setVia(via);
                Call<Indirizzo> call = apiService.SelezionePosizione(via, civico, cap, citta);
                call.enqueue(new Callback<Indirizzo>() {
                                 @Override
                                 public void onResponse(Call<Indirizzo> call, Response<Indirizzo> response) {

                                 }

                                 @Override
                                 public void onFailure(Call<Indirizzo> call, Throwable t) {

                                 }
                             });
                return i.getId();
            }else {
                int i = Integer.parseInt(Ris);
                Call<Indirizzo> call = apiService.ConfermaPosizione(i);
                call.enqueue(new Callback<Indirizzo>() {
                    @Override
                    public void onResponse(Call<Indirizzo> call, Response<Indirizzo> response) {

                    }

                    @Override
                    public void onFailure(Call<Indirizzo> call, Throwable t) {

                    }
                });
                return i;
            }
        }
    }
