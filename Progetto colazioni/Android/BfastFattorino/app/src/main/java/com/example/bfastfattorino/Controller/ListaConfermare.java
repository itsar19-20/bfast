package com.example.bfastfattorino.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastfattorino.R;
import com.example.bfastfattorino.Session.SessionMarker;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.OrdineJSON;
import com.example.bfastfattorino.Utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListaConfermare extends AppCompatActivity {

    ListView listview;
    List<OrdineJSON> ordineJSON;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    CustomAdapter customAdapter;
    SessionMarker sessionMarker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ordini);
        listview = findViewById(R.id.lista);

        Call<List<OrdineJSON>> callUpdateProdotto = apiService.OrdiniDaFare();
        callUpdateProdotto.enqueue(new Callback<List<OrdineJSON>>() {

            @Override
            public void onResponse(Call<List<OrdineJSON>> call, Response<List<OrdineJSON>> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ListaConfermare.this, "Problemi con la risposta del server per gli ordini", Toast.LENGTH_SHORT).show();
                } else if(response.body().size()!=0){
                    ordineJSON = response.body();
                    customAdapter = new CustomAdapter(ordineJSON, ListaConfermare.this);
                    listview.setAdapter(customAdapter);
                }else{
                    Toast.makeText(ListaConfermare.this, "Nessun prodotto attualmente disponibile", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<OrdineJSON>> call, Throwable t) {
                Toast.makeText(ListaConfermare.this, "Nessun prodotto attualmente disponibile", Toast.LENGTH_SHORT).show();
            }
        });


    }

    class CustomAdapter extends BaseAdapter {

        private List<OrdineJSON> lista = new ArrayList<>();
        private List<OrdineJSON> lista2 = new ArrayList<>();
        private Context context;
        TextView tx1,tx2;

        public CustomAdapter(List<OrdineJSON> lista, Context context) {
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
            view = inflater.inflate(R.layout.list_itemeff,null);

            tx1 = view.findViewById(R.id.prodotto);
            tx2 = view.findViewById(R.id.ingredienti);

            tx1.setText("Bar: "+String.valueOf(lista2.get(position).getId()));
            tx2.setText("Prodotti: "+lista2.get(position).getProdotto());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sessionMarker = new SessionMarker(ListaConfermare.this);
                    sessionMarker.setIDBar(lista2.get(position).getId());
                    sessionMarker.setIDOrd(lista2.get(position).getIdord());
                    Intent ord = new Intent(ListaConfermare.this, ConfermaOrdine.class);
                    startActivity(ord);
                }
            });

            return view;
        }
    }

    @Override
    protected void onDestroy() {
        Intent toHome = new Intent(ListaConfermare.this, DashboardActivity.class);
        startActivity(toHome);
        super.onDestroy();
    }

}
