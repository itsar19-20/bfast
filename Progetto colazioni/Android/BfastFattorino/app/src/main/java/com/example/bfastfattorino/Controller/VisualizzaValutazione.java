package com.example.bfastfattorino.Controller;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastfattorino.R;
import com.example.bfastfattorino.Session.SessionFat;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.RetrofitUtils;
import com.example.bfastfattorino.Utils.ValutazioneFattJSON;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizzaValutazione extends AppCompatActivity {

    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    SessionFat sessionFat;
    TextView t1,t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valutazione);

        t1 = findViewById(R.id.Txval);
        t2 = findViewById(R.id.TXtesto);

        sessionFat = new SessionFat(VisualizzaValutazione.this);
        Call<ValutazioneFattJSON> call = apiService.ValutazioneFattorino(String.valueOf(sessionFat.getIDfatt()));
        call.enqueue(new Callback<ValutazioneFattJSON>() {

            @Override
            public void onResponse(Call<ValutazioneFattJSON> call, Response<ValutazioneFattJSON> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(VisualizzaValutazione.this, "Errore con la risposta del server ", Toast.LENGTH_LONG).show();
                }else{
                    ValutazioneFattJSON val = response.body();
                    if (val != null) {
                        float f = val.getVal();
                        t1.setText(String.valueOf(f));
                        if (f > 0 && f < 1) {
                            t2.setText("Malissimo se continui così ti lincenziamo");
                        }else if(f >= 1 && f< 2){
                            t2.setText("Cerca di migliorare sei a rischio!");
                        }else if(f >= 2 && f<3){
                            t2.setText("Devi migliorare ma il tuo lavoro risulta appena sufficiente");
                        }else if(f>=3 && f<4){
                            t2.setText("Molto bene ma puoi ancora migliorare");
                        }else if(f>=4 && f<5){
                            t2.setText("Ottimo lavoro siamo fieri di te");
                        }else if (f == 5){
                            t2.setText("Aumento immediato,Contattaci subito");
                        }
                    }else{
                        t1.setText("0");
                        t2.setText("Svolgi almeno un ordine prima di consultare la media delle valutazioni");
                    }

                }

            }

            @Override
            public void onFailure(Call<ValutazioneFattJSON> call, Throwable t) {
                Toast.makeText(VisualizzaValutazione.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();
            }

        });
    }

}
