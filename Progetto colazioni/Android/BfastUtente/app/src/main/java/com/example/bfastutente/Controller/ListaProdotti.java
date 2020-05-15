package com.example.bfastutente.Controller;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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
import java.util.ArrayList;
import java.util.List;


class ListaProdotti extends AppCompatActivity {

    ListView listview;
    List<Prodotto> lista = new ArrayList<>();
    CustomAdapter customAdapter;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listaprodotti);
        setTooblar();
        listview = findViewById(R.id.lista);

        try {
            List<String> prodotto = new ArrayList<>();
            prodotto = pdb.getIdProdotto();
            for (int i = 0; i < prodotto.size(); i ++) {
                Prodotto p = (Prodotto) pdb.getProdottoLogin(prodotto.get(i).toString());
                lista.add(p);
            }

            customAdapter = new CustomAdapter(lista,this);

            listview.setAdapter(customAdapter);
        }catch(Exception e) {
            Toast.makeText(ListaProdotti.this, "Nessun prodotto attualmente disponibile", Toast.LENGTH_SHORT).show();
            System.out.println("HibernateException Occured!!" + e);
            e.printStackTrace();
        }

    }

    public class CustomAdapter extends BaseAdapter {

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
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = getLayoutInflater().inflate(R.layout.list_item,null);

            tx1 = findViewById(R.id.prodotto);
            tx2 = findViewById(R.id.ingredienti);

            tx1.setText(lista2.get(position).getNome());
            tx2.setText(lista2.get(position).getIngredienti());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent selezione = new Intent(ListaProdotti.this, MapActivity.class);// da reindirizzare al carrello
                    startActivity(selezione);
                }
            });

            return null;
        }
    }

    public void setTooblar() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Button btnSave = findViewById(R.id.btn_done_toolbarCreate);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(ListaProdotti.this, Carrello.class);
                startActivity(toHome);
            }
        });

    }

    @Override
    protected void onDestroy() {
        pdb.close();
        super.onDestroy();
    }

}
