package com.ifts.bfastutente.Business;

import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionUte;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InserisciValutazione extends AppCompatActivity {
    private SessionUte session;
    private SQLiteDatabase db;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    public void inserisci(final float valutazione){
        UserDBAdapter udb = new UserDBAdapter(this);
        final OrdineDBAdapter odb = new OrdineDBAdapter(this);
        String mail = session.getMailUt();
        Utente user = (Utente) udb.getUserLogin(mail);
        String val = Float.toString(valutazione);
        Call<Ordine> call = apiService.ValutazioneFattorino(val);
        call.enqueue(new Callback<Ordine>() {
                         @Override
                         public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                             odb.setValutazioneOrdine(valutazione);
                         }

                         @Override
                         public void onFailure(Call<Ordine> call, Throwable t) {
                             Toast.makeText(InserisciValutazione.this, "Errore nella valutazione", Toast.LENGTH_LONG).show();
                         }
                     });

    }

}
