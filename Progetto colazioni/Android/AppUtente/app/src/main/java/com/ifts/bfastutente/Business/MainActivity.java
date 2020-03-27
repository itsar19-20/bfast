package com.ifts.bfastutente.Business;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.BarDBAdapter;
import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    final String PREFS_NAME = "MyPrefsFile";
    SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
    private List<Integer> idBar;
    private List<String> nomeProdotti;
    private int idbar,idIn;
    private String email,nome,oraApe,oraChi,pass,tipo,Nome,ingre;
    private float fascia,val,prezzo;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    BarDBAdapter bdb = new BarDBAdapter(this);
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.BtnLogin);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (settings.getBoolean("my_first_time", false)) {
                    updateDB();
                } else {
                    createDB();
                }
                Intent login = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(login);
            }

        });

    }
    public void updateDB() {
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("L'operazione richiede fino a 10 secondi");
        progressDialog.setTitle("Aggiornando i dati...");
        idBar = new ArrayList<>();
        bdb.open();
        pdb.open();
        idBar = bdb.getIdBar();
        nomeProdotti = pdb.getIdProdotto();
        progressDialog.show();
        Call<List<Bar>> callUpdateBar = apiService.PrendiBar(idBar.);
        callUpdateBar.enqueue(new Callback<List<Bar>>() {
                               @Override
                               public void onResponse(Call<List<Bar>> call, Response<List<Bar>> response) {
                                   List<Bar> risposta = response.body();
                                   for(int i =0; i < risposta.size();i++){
                                       if(!idBar.contains(risposta.get(i).getId())){
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
                               }

                               @Override
                               public void onFailure(Call<List<Bar>> call, Throwable t) {

                               }
                           });
                bdb.close();
                Call<List<Prodotto>> callUpdateProdotto = apiService(idBar.);
                callUpdateProdotto.enqueue(new Callback<List<Prodotto>>() {
                                       @Override
                                       public void onResponse(Call<List<Prodotto>> call, Response<List<Prodotto>> response) {
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

                                       @Override
                                       public void onFailure(Call<List<Prodotto>> call, Throwable t) {

                                       }
                                   }

                    @Override
                    public void onFailure(Call<List<Prodotto>> call, Throwable t) {

                    });
                progressDialog.dismiss();


    }

    public void createDB(){
        final ProgressDialog progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("L'operazione richiede fino a 10 secondi");
        progressDialog.setTitle("Aggiornando i dati...");
        idBar = new ArrayList<>();
        bdb.open();
        pdb.open();
        idBar = bdb.getIdBar();
        nomeProdotti = pdb.getIdProdotto();
        progressDialog.show();
        Call<List<Bar>> callPrezzi = apiService.PrendiBar();
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

            }
        });
        progressDialog.dismiss();

    }

}
