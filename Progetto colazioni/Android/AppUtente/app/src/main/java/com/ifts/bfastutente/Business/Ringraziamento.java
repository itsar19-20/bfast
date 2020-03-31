package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.R;

public class Ringraziamento extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//set layout ringraziamanti
        b1 = findViewById(R.id.button2);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent fine = new Intent(Ringraziamento.this, InserisciValutazione.class);
                startActivity(fine);
            }
        });

    }
}