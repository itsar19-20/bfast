package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
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

    TextView t1,t2;
    EditText et1;
    private SessionBar sessionbar;
    private SessionOrdine sessionordine;
    private Ordine or;
    private String data,note,concatenatedStarNames = "";;
    private int paga,idord;
    private OrdineDBAdapter odb = new OrdineDBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        t1 = findViewById(R.id.ETcognome); //nome bar
        t2 = findViewById(R.id.ETcopass); //lista prodotti
        idord= sessionordine.getIDOrd();
        t1.setText(sessionbar.getIDBar());
        odb.open();

        List<String> prodotto = new ArrayList<>();
        prodotto = odb.getIdProdotto(sessionordine.getIDOrd());
        for (int i = 0; i < prodotto.size(); i ++) {
            Prodotto pr = null;
            concatenatedStarNames += prodotto.get(i);
        }
        t2.setText(concatenatedStarNames);
        et1 = findViewById(R.id.ETnome);
        note = et1.getText().toString();
        odb.finecarrello(data,note,paga);
        Intent ringraziamento = new Intent(Carrello.this, Ringraziamento.class);
        startActivity(ringraziamento);
    }
}
