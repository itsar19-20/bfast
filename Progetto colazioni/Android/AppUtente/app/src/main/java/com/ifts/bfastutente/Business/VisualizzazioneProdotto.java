package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionProdotto;

public class VisualizzazioneProdotto extends AppCompatActivity {

    EditText et,et2;
    Button b1;
    private SessionProdotto session;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    private Prodotti prodotti;
    private int quantita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        et = findViewById(R.id.ETcognome); //nome prodotto
        et2 = findViewById(R.id.ETnome);//ingrediente
        String nome = session.getNomeProdotto();
        Prodotto p = (Prodotto) pdb.getProdottoLogin(nome);
        et.setText(nome);
        et2.setText(p.getIngredienti());
        //prendere grazie a un enum la quantita
        b1 = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodotti.selezione(quantita);
                Intent reg= new Intent(VisualizzazioneProdotto.this, ListaProdotti.class);
                startActivity(reg);
            }
        });


    }
}
