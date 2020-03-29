package com.ifts.bfastfattorino.Business;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.R;

class ControllaOrdini extends AppCompatActivity {

    private SQLiteDatabase db;
    private TextView tv1,tv2,tv3;
    private double posx,posy;
    private String nomeBar;
    private Button b1,b2;
    private int count =  0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //schermata con l'ordine
        Cursor ris = db.rawQuery("SELECT i.x,i.y,b.Nome FROM Ordine as o,Indirizzo as i,Bar as b WHERE o.confermato =" + 1 + "AND o.IDfatFK = NULL AND b.ID = o.IDbarFK", null);
        //prende i singoli elementi della prima riga
        while(count<ris.getCount()) {
            tv1 = findViewById(R.id.Registrazione); //3 Edittext da rivedere in base alla schermata
            tv2 = findViewById(R.id.Registrazione);
            tv3 = findViewById(R.id.Registrazione);
            String x = Double.toString(posx);
            String y = Double.toString(posy);
            tv1.setText(x);
            tv2.setText(y);
            tv3.setText(nomeBar);
            b1 = findViewById(R.id.button3);//confermato
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent viaggio = new Intent(ControllaOrdini.this, ViaggioFattorino.class);
                    startActivity(viaggio);
                }
            });
            b2 = findViewById(R.id.button);
            b2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    count++;
                }
            });
        }

        Intent cambio = new Intent(ControllaOrdini.this, ConfigurazioneOnline.class);
        startActivity(cambio);
    }

}
