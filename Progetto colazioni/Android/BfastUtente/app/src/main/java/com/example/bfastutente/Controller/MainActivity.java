package com.example.bfastutente.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.bfastutente.Adapter.BarDBAdapter;
import com.example.bfastutente.Adapter.ProdottoDBAdapter;
import com.example.bfastutente.Model.Bar;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.R;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private List<Integer> idBar;
    private List<String> nomeProdotti;
    private int idbar,idIn;
    private String email,nome,oraApe,oraChi,pass,tipo,Nome,ingre;
    private float fascia,val,prezzo;
    private Bar b;
    private Prodotto p;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    BarDBAdapter bdb = new BarDBAdapter(this);
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    Button b1,b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.BtnLogin);
        b2 = findViewById(R.id.BtnSign);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDB();
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
            }


         });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateDB();
                Intent registrazione = new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(registrazione);
            }


        });

    }
    public void createDB(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("L'operazione richiede fino a 10 secondi");
        progressDialog.setTitle("Preparand la tua prima esperienza..");
        idBar = new ArrayList<>();
        bdb.open();
        pdb.open();
        progressDialog.show();
        Call<List<Bar>> callPrezzi = apiService.UpdateBar();
        callPrezzi.enqueue(new Callback<List<Bar>>() {
            @Override
            public void onResponse(Call<List<Bar>> call, Response<List<Bar>> response) {
                List<Bar> risposta = response.body();
                for(int i =0; i < risposta.size();i++){
                    idbar = risposta.get(i).getId();
                    email = risposta.get(i).getEmail();
                    idIn = risposta.get(i).getIdIndirizzo();
                    nome = risposta.get(i).getNome();
                    oraApe = risposta.get(i).getOrarioApertura();
                    oraChi = risposta.get(i).getOrarioChiusura();
                    pass = risposta.get(i).getPassword();
                    val = risposta.get(i).getFascia();
                    fascia = risposta.get(i).getFascia();
                    try {
                        bdb.insBar(idbar,idIn,email,pass,nome,val,oraApe,oraChi,fascia);
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }

                }
            }

            @Override
            public void onFailure(Call<List<Bar>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connessione al server assente", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        bdb.close();
        Call<List<Prodotto>> callUpdateProdotto = apiService.UpdateProdotto();
        callUpdateProdotto.enqueue(new Callback<List<Prodotto>>() {
            @Override
            public void onResponse(Call<List<Prodotto>> call, Response<List<Prodotto>> response) {
                List<Prodotto> risposta = response.body();
                for (int i = 0; i < risposta.size(); i++) {
                    Nome = risposta.get(i).getNome();
                    ingre = risposta.get(i).getIngredienti();
                    prezzo = risposta.get(i).getPrezzo();
                    tipo = risposta.get(i).getTipo();
                    try {
                        pdb.addProdotto(Nome, ingre, prezzo, tipo);
                    } catch (Exception e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Prodotto>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connessione al server assente", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        progressDialog.dismiss();
        pdb.close();

    }
    public void updateDB() {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("L'operazione richiede fino a 10 secondi");
        progressDialog.setTitle("Aggiornando i dati...");
        idBar = new ArrayList<>();
        bdb.open();
        progressDialog.show();
        Call<List<Bar>> callUpdateBar = apiService.UpdateBar();
        callUpdateBar.enqueue(new Callback<List<Bar>>() {
            @Override
            public void onResponse(Call<List<Bar>> call, Response<List<Bar>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Problemi con la rispota del server per il Bar", Toast.LENGTH_SHORT).show();
                    }else {
                        List<Bar> risposta = response.body();
                        for(int i =0; i < risposta.size();i++){
                        if (!idBar.contains(risposta.get(i).getId())) {
                            idbar = risposta.get(i).getId();
                            email = risposta.get(i).getEmail();
                            idIn = risposta.get(i).getIdIndirizzo();
                            nome = risposta.get(i).getNome();
                            oraApe = risposta.get(i).getOrarioApertura();
                            oraChi = risposta.get(i).getOrarioChiusura();
                            pass = risposta.get(i).getPassword();
                            val = risposta.get(i).getFascia();
                            fascia = risposta.get(i).getFascia();
                            try {
                                bdb.insBar(idbar, idIn, email, pass, nome, val, oraApe, oraChi, fascia);
                            } catch (Exception e) {
                                System.out.println(e.getLocalizedMessage());
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Bar>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connessione al server assente", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
        bdb.close();
        pdb.open();
        Call<List<Prodotto>> callUpdateProdotto = apiService.UpdateProdotto();
        callUpdateProdotto.enqueue(new Callback<List<Prodotto>>() {
            @Override
            public void onResponse(Call<List<Prodotto>> call, Response<List<Prodotto>> response) {
                    if (!response.isSuccessful()) {
                        Toast.makeText(MainActivity.this, "Problemi con la rispota del server per il Prodotto", Toast.LENGTH_SHORT).show();
                    }else {
                        List<Prodotto> risposta = response.body();
                        for (int i = 0; i < risposta.size(); i++) {
                        if (!nomeProdotti.contains(risposta.get(i).getNome())) {
                            Nome = risposta.get(i).getNome();
                            ingre = risposta.get(i).getIngredienti();
                            prezzo = risposta.get(i).getPrezzo();
                            tipo = risposta.get(i).getTipo();
                            try {
                                pdb.addProdotto(Nome, ingre, prezzo, tipo);
                            } catch (Exception e) {
                                System.out.println(e.getLocalizedMessage());
                            }
                        }
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Prodotto>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Connessione al server assente", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });

        progressDialog.dismiss();


    }
}
