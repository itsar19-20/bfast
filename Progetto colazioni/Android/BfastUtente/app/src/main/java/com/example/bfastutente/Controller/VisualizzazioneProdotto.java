package com.example.bfastutente.Controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import com.example.bfastutente.Adapter.ProdottoDBAdapter;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionProdotto;


public class VisualizzazioneProdotto extends AppCompatActivity {

    TextView tx;
    EditText et;
    Button b1;
    private SessionProdotto session;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter(this);
    private int quantita;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzaprodotto);
        tx = findViewById(R.id.Prodotto); //nome prodotto
        et = findViewById(R.id.Quantita);//ingrediente
        String nome = session.getNomeProdotto();
        Prodotto p = (Prodotto) pdb.getProdottoLogin(nome);
        tx.setText(nome);
        et.setText(p.getIngredienti());
        b1 = findViewById(R.id.btnconfpro);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(VisualizzazioneProdotto.this, "Aggiunto al tuo ordine", Toast.LENGTH_SHORT).show();
            }


        });
    }
}
