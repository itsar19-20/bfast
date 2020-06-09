package com.example.bfastutente.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Model.OrderStatusModel;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionSomma;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.OrdineJson;
import com.example.bfastutente.Utils.RetrofitUtils;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Ringraziamento extends AppCompatActivity {

    Button b1;
    ListView listview;
    ImageView im;
    CustomAdapter customAdapter;
    TextView tx, t2, t3;
    private int quantita;
    String et = "0";
    List<OrderStatusModel> arrayOfStatus = OrderStatusModel.getStoreDetail();
    SessionOrdine sessionOrdine;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringraziamento);
        listview = findViewById(R.id.list);
        customAdapter = new CustomAdapter(arrayOfStatus, Ringraziamento.this);
        listview.setAdapter(customAdapter);


    }

    class CustomAdapter extends BaseAdapter {

        private List<OrderStatusModel> lista = new ArrayList<>();
        private List<OrderStatusModel> lista2 = new ArrayList<>();
        private Context context;
        TextView tx1, tx2;

        public CustomAdapter(List<OrderStatusModel> lista, Context context) {
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
            view = inflater.inflate(R.layout.item_timeline, null);

            tx = view.findViewById(R.id.tv_status);
            im = view.findViewById(R.id.iv_circle);
            tx.setText(lista2.get(position).getTv_status());
            b1 = findViewById(R.id.BTNfvalu);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent fine = new Intent(Ringraziamento.this, InserisciValutazione.class);
                    startActivity(fine);
                }
            });
            if(position==0){
                im.setImageResource(R.drawable.marker);
            }

            final View finalView = view;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(position==1){
                        sessionOrdine = new SessionOrdine(Ringraziamento.this);
                        Call<OrdineJson> confermato = apiService.OrdineConfermato(String.valueOf(sessionOrdine.getIDOrd()));
                        confermato.enqueue(new Callback<OrdineJson>() {
                            @Override
                            public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(Ringraziamento.this, "Problema con la Time Line", Toast.LENGTH_SHORT).show();
                                }else{
                                    OrdineJson oj = response.body();
                                    if(oj==null){
                                        Toast.makeText(Ringraziamento.this, "Ordine Rifiutato", Toast.LENGTH_SHORT).show();
                                        Intent fine = new Intent(Ringraziamento.this, MapActivity.class);
                                        startActivity(fine);
                                    }else if(Integer.parseInt(oj.getId())==0){
                                        Toast.makeText(Ringraziamento.this, "Ordine non ancora confermato", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Ringraziamento.this, "Ordine Accettato", Toast.LENGTH_SHORT).show();
                                        im = finalView.findViewById(R.id.iv_circle);
                                        im.setImageResource(R.drawable.marker);
                                    }
                                }

                            }

                            @Override
                            public void onFailure(Call<OrdineJson> call, Throwable t) {
                                Toast.makeText(Ringraziamento.this, "Problema col server", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                    if(position==2){
                        Toast.makeText(Ringraziamento.this, "Ordine preparato", Toast.LENGTH_SHORT).show();
                        im = finalView.findViewById(R.id.iv_circle);
                        im.setImageResource(R.drawable.marker);
                    }
                    if(position==3){
                        sessionOrdine = new SessionOrdine(Ringraziamento.this);
                        Call<OrdineJson> fattorino = apiService.FattorinoConfermato(String.valueOf(sessionOrdine.getIDOrd()));
                        fattorino.enqueue(new Callback<OrdineJson>() {
                            @Override
                            public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(Ringraziamento.this, "Problema con la Time Line", Toast.LENGTH_SHORT).show();
                                }else{
                                    OrdineJson oj = response.body();
                                    if(oj==null){
                                        Toast.makeText(Ringraziamento.this, "Ordine non ancora consegnato", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Ringraziamento.this, "Ordine consegnato", Toast.LENGTH_SHORT).show();
                                        im = finalView.findViewById(R.id.iv_circle);
                                        im.setImageResource(R.drawable.marker);
                                        b1.setVisibility(View.VISIBLE);
                                    }
                                }
                            }

                            @Override
                            public void onFailure(Call<OrdineJson> call, Throwable t) {
                                Toast.makeText(Ringraziamento.this, "Problema col server", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
            });
            return view;
        }
    }


}
