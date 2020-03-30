package com.ifts.bfastutente.Business;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionProdotto;

public class VisualizzazioneProdotto extends AppCompatActivity {

    EditText et,et2;
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
        prodotti.selezione(quantita);

    }
}
