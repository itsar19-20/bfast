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
import com.example.bfastutente.Model.Contiene;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionProdotto;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class VisualizzazioneProdotto extends AppCompatActivity {

    TextView tx;
    EditText et;
    Button b1;
    private SessionProdotto session;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter(this);
    private int quantita;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    SessionOrdine sessionOrdine;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizzaprodotto);
        tx = findViewById(R.id.Prodotto);
        et = findViewById(R.id.Quantita);
        session = new SessionProdotto(VisualizzazioneProdotto.this);
        final String nome = session.getNomeProdotto();
        tx.setText(nome);
        b1 = findViewById(R.id.btnconfpro);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String check = et.getText().toString();
                if(check.equals("")){
                    Toast.makeText(VisualizzazioneProdotto.this, "Non hai selezionato nessuna quantita", Toast.LENGTH_SHORT).show();
                }else{
                    /*sessionOrdine = new SessionOrdine(VisualizzazioneProdotto.this);
                    Call<Contiene> call = apiService.SelezioneProdotto(String.valueOf(sessionOrdine.getIDOrd()),nome,check);
                    call.enqueue(new Callback<Contiene>(){
                        @Override
                        public void onResponse(Call<Contiene> call, Response<Contiene> response) {
                            if (!response.isSuccessful()) {
                                Toast.makeText(VisualizzazioneProdotto.this, "Impossibile aggiungerlo al carrello", Toast.LENGTH_SHORT).show();
                            }else{
                                Toast.makeText(VisualizzazioneProdotto.this, "Aggiunto al tuo carrello", Toast.LENGTH_SHORT).show();
                            }
                        }

                        @Override
                        public void onFailure(Call<Contiene> call, Throwable t) {
                            Toast.makeText(VisualizzazioneProdotto.this, "Problema col server", Toast.LENGTH_SHORT).show();
                        }
                    });*/
                    quantita =Integer.parseInt(check);
                    session = new SessionProdotto(VisualizzazioneProdotto.this);
                    session.confermarto(1);
                    Intent selezione = new Intent(VisualizzazioneProdotto.this, ListaProdotti.class);
                    startActivity(selezione);
                }

            }


        });
    }
}
