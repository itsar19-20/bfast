package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.R;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText etval = findViewById(R.id.ETmail);
        final float valutazione = Float.valueOf(etval.getText().toString());
        UserDBAdapter udb = new UserDBAdapter(this);
        final OrdineDBAdapter odb = new OrdineDBAdapter(this);
        String mail = session.getMailUt();
        Utente user = (Utente) udb.getUserLogin(mail);
        Call<Ordine> call = apiService.ValutazioneFattorino(valutazione);
        call.enqueue(new Callback<Ordine>() {
                         @Override
                         public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                             odb.setValutazioneOrdine(valutazione);
                             Intent fine = new Intent(InserisciValutazione.this, MapActivity.class);
                             startActivity(fine);
                         }

                         @Override
                         public void onFailure(Call<Ordine> call, Throwable t) {
                             Toast.makeText(InserisciValutazione.this, "Errore nella valutazione", Toast.LENGTH_LONG).show();
                         }
                     });

    }

}
