package com.ifts.bfastfattorino.Business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.R;

public class ConfigurazioneOnline extends AppCompatActivity {
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //schermata con il bottone rosso
        b1 = findViewById(R.id.Registrazione); //bottone rosso
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent login = new Intent(ConfigurazioneOnline.this, ControllaOrdini.class);
                startActivity(login);
            }
        });

    }
}
