package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionSomma;

public class Ringraziamento extends AppCompatActivity {

    Button b1;
    SessionSomma sessionSomma;
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringraziamento);
        sessionSomma = new SessionSomma(Ringraziamento.this);
        String totale = "Il totale è "+sessionSomma.getSomma();
        t1 = findViewById(R.id.TXtotale);
        t1.setText(totale);
        b1 = findViewById(R.id.BTNfvalu);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fine = new Intent(Ringraziamento.this, InserisciValutazione.class);
                startActivity(fine);
            }
        });

    }
}
