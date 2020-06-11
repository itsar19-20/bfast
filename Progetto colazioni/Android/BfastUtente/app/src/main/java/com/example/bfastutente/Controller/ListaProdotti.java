package com.example.bfastutente.Controller;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.example.bfastutente.Adapter.ProdottoDBAdapter;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionProdotto;
import com.example.bfastutente.Session.SessionSomma;
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
    SessionSomma sessionSomma;
    TextView tx,t2,t3;
    Button b1;
    ElegantNumberButton but;
    private int quantita;
    Dialog myDialog;
    String et ="0";


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
                    sessionOrdine = new SessionOrdine(ListaProdotti.this);
                    Call<OrdineJson> cancellazione = apiService.cancellazione(String.valueOf(sessionOrdine.getIDOrd()));
                    cancellazione.enqueue(new Callback<OrdineJson>() {
                        @Override
                        public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(ListaProdotti.this, "Errore nel server", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(ListaProdotti.this, "Nessun prodotto attualmente disponibile", Toast.LENGTH_SHORT).show();
                                Intent toHome = new Intent(ListaProdotti.this, MapActivity.class);
                                startActivity(toHome);
                            }
                        }

                        @Override
                        public void onFailure(Call<OrdineJson> call, Throwable t) {
                            Toast.makeText(ListaProdotti.this, "Errore nel server", Toast.LENGTH_SHORT).show();
                        }
                    });
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
            myDialog = new Dialog(context);

            tx1 = view.findViewById(R.id.prodotto);
            tx2 = view.findViewById(R.id.ingredienti);

            tx1.setText(lista2.get(position).getNome());
            tx2.setText(lista2.get(position).getIngredienti());

            final View finalView = view;
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    sessionPro = new SessionProdotto(ListaProdotti.this);
                    final String nome = lista2.get(position).getNome();
                    sessionOrdine = new SessionOrdine(ListaProdotti.this);
                    Call<OrdineJson> presente = apiService.CercaCarrello(String.valueOf(sessionOrdine.getIDOrd()),nome);
                    presente.enqueue(new Callback<OrdineJson>() {
                        @Override
                        public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                            if (!response.isSuccessful()) {
                                ShowPopup(finalView,nome,0);
                            }else {
                                OrdineJson c = response.body();
                                if(c==null){
                                    ShowPopup(finalView,nome,0);
                                }else{
                                    ShowPopup(finalView,nome,1);
                                }
                            }
                        }

                        @Override
                        public void onFailure(Call<OrdineJson> call, Throwable t) {
                            Toast.makeText(ListaProdotti.this, "Problema col server", Toast.LENGTH_SHORT).show();
                        }
                    });
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

    public void ShowPopup(View v,String Nome,int set) {
        myDialog.setContentView(R.layout.popupprodotto);
        tx = (TextView) myDialog.findViewById(R.id.Prodotto);
        t2 = (TextView) myDialog.findViewById(R.id.TXcosto);
        t3 = (TextView) myDialog.findViewById(R.id.Rimuovi);
        if(set==1){
            t3.setCursorVisible(true);
            t3.setVisibility(View.VISIBLE);
        }
        TextView txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        sessionPro = new SessionProdotto(ListaProdotti.this);
        final String nome = Nome;
        Call<Prodotto> call = apiService.CostoProdotto(nome);
        call.enqueue(new Callback<Prodotto>(){
            @Override
            public void onResponse(Call<Prodotto> call, Response<Prodotto> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(ListaProdotti.this, "Impossibile visualizzare il prezzo", Toast.LENGTH_SHORT).show();
                }else{
                    Prodotto p = response.body();
                    t2.setText(String.valueOf(p.getPrezzo()));
                }
            }

            @Override
            public void onFailure(Call<Prodotto> call, Throwable t) {
                Toast.makeText(ListaProdotti.this, "Problema col server", Toast.LENGTH_SHORT).show();
            }
        });
        but = (ElegantNumberButton ) myDialog.findViewById(R.id.Quantita);
        tx.setText(nome);
        b1 = (Button) myDialog.findViewById(R.id.btnvalid);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sessionSomma = new SessionSomma(ListaProdotti.this);
                sessionOrdine = new SessionOrdine(ListaProdotti.this);
                Call<OrdineJson> rimuovi = apiService.RimuoviCarrello(String.valueOf(sessionOrdine.getIDOrd()),nome);
                rimuovi.enqueue(new Callback<OrdineJson>() {
                    @Override
                    public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(ListaProdotti.this, "Impossibile cancellare il prodotto", Toast.LENGTH_SHORT).show();
                        }else{
                            float costo = 0;
                            try{
                                costo = Float.parseFloat(t2.getText().toString());
                            }catch(Exception e){

                            }
                            Toast.makeText(ListaProdotti.this, "Prodotto cancellato", Toast.LENGTH_SHORT).show();
                            OrdineJson oj = response.body();
                            float somma = sessionSomma.getSomma();
                            somma = somma - (costo*Integer.parseInt(oj.getId()));
                            sessionSomma.setSomma(somma);
                            myDialog.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<OrdineJson> call, Throwable t) {
                        Toast.makeText(ListaProdotti.this, "Problema col server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

        but.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                et = but.getNumber();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = myDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);
        myDialog.show();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = et;
                if(check.equals("0")){
                    Toast.makeText(ListaProdotti.this, "Non hai selezionato nessuna quantita", Toast.LENGTH_SHORT).show();
                }else{
                    sessionSomma = new SessionSomma(ListaProdotti.this);
                    sessionOrdine = new SessionOrdine(ListaProdotti.this);
                    Call<OrdineJson> call = apiService.SelezioneProdotto(String.valueOf(sessionOrdine.getIDOrd()),nome,check);
                    call.enqueue(new Callback<OrdineJson>(){
                        @Override
                        public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(ListaProdotti.this, "Impossibile aggiungerlo al carrello", Toast.LENGTH_SHORT).show();
                            }else{
                                float costo = 0;
                                try{
                                    costo = Float.parseFloat(t2.getText().toString());
                                }catch(Exception e){

                                }
                                float somma = sessionSomma.getSomma();
                                somma = somma + (costo*quantita);
                                sessionSomma.setSomma(somma);
                                Toast.makeText(ListaProdotti.this, "Aggiunto al tuo carrello", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<OrdineJson> call, Throwable t) {
                            Toast.makeText(ListaProdotti.this, "Problema col server", Toast.LENGTH_SHORT).show();
                        }
                    });
                    quantita =Integer.parseInt(check);
                    sessionPro = new SessionProdotto(ListaProdotti.this);
                    sessionPro.confermarto(1);
                    myDialog.dismiss();
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