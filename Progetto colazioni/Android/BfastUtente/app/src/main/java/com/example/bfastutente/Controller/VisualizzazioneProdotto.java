package com.example.bfastutente.Controller;

import android.content.Intent;
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
    SessionProdotto sessionProdotto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzaprodotto);
        tx = findViewById(R.id.Prodotto);
        et = findViewById(R.id.Quantita);
        session = new SessionProdotto(VisualizzazioneProdotto.this);
        String nome = session.getNomeProdotto();
        tx.setText(nome);
        b1 = findViewById(R.id.btnconfpro);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = et.getText().toString();
                if(check.equals("")){
                    Toast.makeText(VisualizzazioneProdotto.this, "Non hai selezionato nessuna quantita", Toast.LENGTH_SHORT).show();
                }else{
                    quantita =Integer.parseInt(check);
                    Toast.makeText(VisualizzazioneProdotto.this, "Aggiunto al tuo carrello", Toast.LENGTH_SHORT).show();
                    sessionProdotto = new SessionProdotto(VisualizzazioneProdotto.this);
                    sessionProdotto.confermarto(1);
                    Intent selezione = new Intent(VisualizzazioneProdotto.this, ListaProdotti.class);
                    startActivity(selezione);
                }

            }


        });
    }
}
