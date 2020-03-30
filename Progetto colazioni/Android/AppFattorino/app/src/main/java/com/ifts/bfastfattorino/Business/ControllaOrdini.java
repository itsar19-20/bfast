package com.ifts.bfastfattorino.Business;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.ifts.bfastfattorino.Adapter.OrdineDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Ordine;
import com.ifts.bfastfattorino.R;
import com.ifts.bfastfattorino.Sessioni.SessionFat;
import com.ifts.bfastfattorino.Utils.BfastFattorinoApi;
import com.ifts.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class ControllaOrdini extends AppCompatActivity {

    private SQLiteDatabase db;
    private TextView tv1,tv2,tv3;
    private double posx,posy;
    private String nomeBar;
    private Button b1,b2;
    private int count =  0;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    private SessionFat session;
    OrdineDBAdapter odb = new OrdineDBAdapter(this);

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
            odb.open();
            b1 = findViewById(R.id.button3);//confermato
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<Ordine> call = apiService.ConfermaOrdine(session.getIDfatt());
                    call.enqueue(new Callback<Ordine>() {
                                     @Override
                                     public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                                         odb.CreazioneFattorino(session.getIDfatt());
                                         odb.close();
                                         Intent viaggio = new Intent(ControllaOrdini.this, ViaggioFattorino.class);
                                         startActivity(viaggio);
                                     }

                                     @Override
                                     public void onFailure(Call<Ordine> call, Throwable t) {

                                     }
                                 });

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
        Toast.makeText(ControllaOrdini.this, "Ordini finiti sei diventato in automatico offline", Toast.LENGTH_LONG).show();
        Intent cambio = new Intent(ControllaOrdini.this, ConfigurazioneOnline.class);
        startActivity(cambio);
    }

    public void setTooblar() {
        Toolbar toolbar = findViewById(R.id.toolbar_createActivity);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        odb.close();
        super.onDestroy();
    }

}
