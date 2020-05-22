package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastfattorino.R;

public class ConfermaOrdine extends AppCompatActivity {

    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confermaord);
        b1 = findViewById(R.id.Btnmappa);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ord = new Intent(ConfermaOrdine.this, MapsActivity.class);
                startActivity(ord);
            }
        });
    }
}
