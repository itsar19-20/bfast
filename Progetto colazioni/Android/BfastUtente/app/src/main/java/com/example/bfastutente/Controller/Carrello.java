package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Adapter.OrdineDBAdapter;
import com.example.bfastutente.Model.Ordine;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;

import java.util.ArrayList;
import java.util.List;

public class Carrello extends AppCompatActivity {

    Button b1;
    TextView t1,t2;
    EditText et1;
    private SessionBar sessionbar;
    private SessionOrdine sessionordine;
    private Ordine or;
    private String ora,data,note,concatenatedStarNames = "";
    private int paga,idord;
    private OrdineDBAdapter odb = new OrdineDBAdapter(this);
    private CheckBox cb1,cb2,cb3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        odb.open();

        try{
            List<String> prodotto = new ArrayList<>();
            prodotto = odb.getIdProdotto(sessionordine.getIDOrd());
            for (int i = 0; i < prodotto.size(); i ++) {
                Prodotto pr = null;
                concatenatedStarNames += prodotto.get(i);
            }
            t2.setText(concatenatedStarNames);
        }catch(Exception e){
            System.out.println("HibernateException Occured!!" + e);
            e.printStackTrace();
        }

        final EditText et1 = findViewById(R.id.ETorario);
        final EditText et2 = findViewById(R.id.Etnote);
        cb1 = findViewById(R.id.checkbox_carta);
        cb3 = findViewById(R.id.checkbox_consegna);
        cb2 = findViewById(R.id.checkbox_paypal);
        cb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paga=1;
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paga=2;
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                paga=3;
            }
        });

        b1 = findViewById(R.id.Etconf);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ora = et1.getText().toString();
                note = et2.getText().toString();
                try{
                    odb.finecarrello(data,note,paga);
                }catch(Exception e){
                    System.out.println("HibernateException Occured!!" + e);
                    e.printStackTrace();
                }
                Intent ringraziamento = new Intent(Carrello.this, Ringraziamento.class);
                startActivity(ringraziamento);
            }
        });

    }
}
