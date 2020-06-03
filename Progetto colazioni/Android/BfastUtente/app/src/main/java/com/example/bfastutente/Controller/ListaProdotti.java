package com.example.bfastutente.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import com.example.bfastutente.Adapter.ProdottoDBAdapter;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionProdotto;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.OrdineJson;
import com.example.bfastutente.Utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ListaProdotti extends AppCompatActivity {

    ListView listview;
    List<Prodotto> lista = new ArrayList<>();
    CustomAdapter customAdapter;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter(this);
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    SessionBar session;
    SessionProdotto sessionPro;
    SessionOrdine sessionOrdine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaprodotti);
        setTooblar();
        listview = findViewById(R.id.lista);

        session = new SessionBar(ListaProdotti.this);
        String id = String.valueOf(session.getIDInd());
        Call<List<Prodotto>> callUpdateProdotto = apiService.ProdottiBar(id);
        callUpdateProdotto.enqueue(new Callback<List<Prodotto>>() {

            @Override
            public void onResponse(Call<List<Prodotto>> call, Response<List<Prodotto>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ListaProdotti.this, "Problemi con la rispota del server per i Prodotti", Toast.LENGTH_SHORT).show();
                } else if(response.body().size()!=0){
                    lista = response.body();
                    customAdapter = new CustomAdapter(lista, ListaProdotti.this);
                    listview.setAdapter(customAdapter);
                }else{
                    Toast.makeText(ListaProdotti.this, "Nessun prodotto attualmente disponibile", Toast.LENGTH_SHORT).show();
                    Intent selezione = new Intent(ListaProdotti.this, MapActivity.class);
                    startActivity(selezione);
                }
            }

            @Override
            public void onFailure(Call<List<Prodotto>> call, Throwable t) {
                try {
                    List<String> prodotto = new ArrayList<>();
                    prodotto = pdb.getIdProdotto();
                    for (int i = 0; i < prodotto.size(); i++) {
                        Prodotto p = (Prodotto) pdb.getProdottoLogin(prodotto.get(i).toString());
                        lista.add(p);
                    }
                } catch (Exception e) {
                    Toast.makeText(ListaProdotti.this, "Nessun prodotto attualmente disponibile", Toast.LENGTH_SHORT).show();
                    System.out.println("HibernateException Occured!!" + e);
                    e.printStackTrace();
                }
            }
        });


    }

    class CustomAdapter extends BaseAdapter {

        private List<Prodotto> lista = new ArrayList<>();
        private List<Prodotto> lista2 = new ArrayList<>();
        private Context context;
        TextView tx1,tx2;

        public CustomAdapter(List<Prodotto> lista, Context context) {
            this.lista = lista;
            this.lista2 = lista;
            this.context = context;
        }

        @Override
        public int getCount() {
            return lista2.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item,null);

            tx1 = view.findViewById(R.id.prodotto);
            tx2 = view.findViewById(R.id.ingredienti);

            tx1.setText(lista2.get(position).getNome());
            tx2.setText(lista2.get(position).getIngredienti());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sessionPro = new SessionProdotto(ListaProdotti.this);
                    String nome = lista2.get(position).getNome();
                    sessionPro.setNomeProdotto(nome);
                    Intent selezione = new Intent(ListaProdotti.this, VisualizzazioneProdotto.class);
                    startActivity(selezione);
                }
            });

            return view;
        }
    }

    public void setTooblar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnSave = findViewById(R.id.btn_done_toolbarCreate);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionPro = new SessionProdotto(ListaProdotti.this);
                int conf = sessionPro.getConfermato();
                if(conf == 0){
                    Toast.makeText(ListaProdotti.this, "Carrello vuoto! Scegli un prodotto", Toast.LENGTH_SHORT).show();
                }else{
                    Intent toHome = new Intent(ListaProdotti.this, Carrello.class);
                    startActivity(toHome);
                }

            }
        });

    }

    @Override
    protected void onDestroy() {
        sessionOrdine = new SessionOrdine(this);
        Call<OrdineJson> cancellazione = apiService.cancellazione(String.valueOf(sessionOrdine.getIDOrd()));
        cancellazione.enqueue(new Callback<OrdineJson>() {
            @Override
            public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ListaProdotti.this, "Errore nel server", Toast.LENGTH_SHORT).show();
                }else{
                    Intent toHome = new Intent(ListaProdotti.this, MapActivity.class);
                    startActivity(toHome);
                }
            }

            @Override
            public void onFailure(Call<OrdineJson> call, Throwable t) {
                Toast.makeText(ListaProdotti.this, "Errore nel server", Toast.LENGTH_SHORT).show();
            }
        });
        super.onDestroy();
    }

}