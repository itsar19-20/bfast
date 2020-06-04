package com.example.bfastfattorino.Controller;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


import com.example.bfastfattorino.Adapter.DomandaDBAdapter;
import com.example.bfastfattorino.Model.Domanda;
import com.example.bfastfattorino.R;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScriviDomanda extends AppCompatActivity {
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText ettesto = findViewById(R.id.ETmail);
        final String testo = ettesto.getText().toString();
        BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
        DomandaDBAdapter ddb = new DomandaDBAdapter();
        Domanda _return = null;
        Cursor ris = db.rawQuery("SELECT d.ID FROM Domanda as d WHERE d.domanda ="+testo,null);

        if (ris == null) {
            Call<Domanda> call = apiService.ScriviDomanda(testo);
            final Domanda final_return = new Domanda();
            call.enqueue(new Callback<Domanda>() {
                             @Override
                             public void onResponse(Call<Domanda> call, Response<Domanda> response) {
                                 final_return.setDomanda(testo);
                             }

                             @Override
                             public void onFailure(Call<Domanda> call, Throwable t) {

                             }
                         });
        }else {
            _return = (Domanda) ddb.getRisposta(ris.getColumnIndex(String.valueOf(0)));
        }
    }



}