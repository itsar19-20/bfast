package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastfattorino.Model.Fattorino;
import com.example.bfastfattorino.R;
import com.example.bfastfattorino.Session.SessionFat;
import com.example.bfastfattorino.Session.SessionMarker;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfermaOrdine extends AppCompatActivity {

    SessionMarker sessionMarker;
    SessionFat sessionFat;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confermaord);
        b1 = findViewById(R.id.Btnmappa);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sessionFat = new SessionFat(ConfermaOrdine.this);
                sessionMarker = new SessionMarker(ConfermaOrdine.this);
                Call<Fattorino> call = apiService.ConfermaOrdine(String.valueOf(sessionMarker.getIDOrd()),String.valueOf(sessionFat.getIDfatt()));
                call.enqueue(new Callback<Fattorino>() {

                    @Override
                    public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(ConfermaOrdine.this, "Impossibile confermare l'ordine", Toast.LENGTH_LONG).show();
                        }else{
                            Intent ord = new Intent(ConfermaOrdine.this, MapsActivity.class);
                            startActivity(ord);
                        }

                    }

                    @Override
                    public void onFailure(Call<Fattorino> call, Throwable t) {
                        Toast.makeText(ConfermaOrdine.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();
                    }

                });
            }
        });
    }
}
