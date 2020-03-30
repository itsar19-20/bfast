package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import com.ifts.bfastfattorino.Adapter.DomandaDBAdapter;
import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.R;
import com.ifts.bfastfattorino.Sessioni.SessionFat;
import com.ifts.bfastfattorino.Utils.BfastFattorinoApi;
import com.ifts.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class ScriviDomanda extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SessionFat session;
    private SQLiteDatabase db;
    BfastFattorinoApi apiService  = RetrofitUtils.getInstance().getBfastFattorinoApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText ettesto = findViewById(R.id.editText5);
        final String testo = ettesto.getText().toString();
        Integer id = session.getIDfatt();
        DomandaDBAdapter ddb = new DomandaDBAdapter();
        Domanda _return = null;
        _return= (Domanda) udba.getUserLogin(id);

        Cursor ris = db.rawQuery("SELECT d.ID FROM Domanda as d WHERE d.domanda ="+testo,null);

        if (ris==null) {
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