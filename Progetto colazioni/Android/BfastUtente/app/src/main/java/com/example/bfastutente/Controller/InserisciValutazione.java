package com.example.bfastutente.Controller;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Adapter.OrdineDBAdapter;
import com.example.bfastutente.Adapter.UserDBAdapter;
import com.example.bfastutente.Model.Ordine;
import com.example.bfastutente.Model.Utente;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionUte;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InserisciValutazione extends AppCompatActivity {

    private SessionUte session;
    private SQLiteDatabase db;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    private Button bt1;
    private RatingBar rb;
    SessionOrdine sessionOrdine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valutazione);
        final EditText etval = findViewById(R.id.ETmail);
        rb = findViewById(R.id.RBval);
        final float valutazione = rb.getRating();
        UserDBAdapter udb = new UserDBAdapter(this);
        final OrdineDBAdapter odb = new OrdineDBAdapter(this);
        session = new SessionUte(InserisciValutazione.this);
        String mail = session.getMailUt();
        bt1 = findViewById(R.id.BTNfine);
        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val = String.valueOf(valutazione);
                sessionOrdine = new SessionOrdine(InserisciValutazione.this);
               /*Call<Ordine> call = apiService.ValutazioneFattorino(String.valueOf(sessionOrdine.getIDOrd()),val);
                call.enqueue(new Callback<Ordine>() {
                    @Override
                    public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(InserisciValutazione.this, "Valutazione non corretta", Toast.LENGTH_LONG).show();
                            Intent fine = new Intent(InserisciValutazione.this, MapActivity.class);
                            startActivity(fine);
                        }else{
                            odb.setValutazioneOrdine(valutazione);
                            Intent fine = new Intent(InserisciValutazione.this, MapActivity.class);
                            startActivity(fine);
                        }
                    }

                    @Override
                    public void onFailure(Call<Ordine> call, Throwable t) {
                        Toast.makeText(InserisciValutazione.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();
                        Intent fine = new Intent(InserisciValutazione.this, MapActivity.class);
                        startActivity(fine);
                    }
                });*/
                Intent fine = new Intent(InserisciValutazione.this, MapActivity.class);
                startActivity(fine);
            }
        });


    }

}
