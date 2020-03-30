package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.OrdineDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionBar;
import com.ifts.bfastutente.Sessioni.SessionOrdine;

import java.util.ArrayList;
import java.util.List;

public class Carrello extends AppCompatActivity {

    TextView t1,t2;
    EditText et1;
    private SessionBar sessionbar;
    private SessionOrdine sessionordine;
    private Ordini or;
    private String data,note,concatenatedStarNames = "";;
    private int paga,idord;
    private OrdineDBAdapter odb = new OrdineDBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
        or.carrello(data,paga,note);
        Intent ringraziamento = new Intent(Carrello.this, Ringraziamento.class);//activity con schermata di ringraziamento
        startActivity(ringraziamento);
    }
}
