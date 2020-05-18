package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.R;

public class Ringraziamento extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringraziamento);
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
