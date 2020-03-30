package com.ifts.bfastfattorino.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.Adapter.PossiedeDBAdapter;
import com.ifts.bfastfattorino.Adapter.RispostaDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Possiede;
import com.ifts.bfastfattorino.ModelAPP.Risposta;
import com.ifts.bfastfattorino.R;
import com.ifts.bfastfattorino.Sessioni.SessionFat;
import com.ifts.bfastfattorino.Utils.BfastFattorinoApi;
import com.ifts.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScriviRisposta extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SQLiteDatabase db;
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    final PossiedeDBAdapter pdb = new PossiedeDBAdapter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText etdomanda = findViewById(R.id.editText5);
        final EditText ettesto = findViewById(R.id.editText7);
        final int domanda = Integer.parseInt(etdomanda.getText().toString());
        String testo = ettesto.getText().toString();
        Integer id = session.getIDfatt();
        Risposta _return = null;
        _return= (Risposta) udba.getUserLogin(id);
        RispostaDBAdapter rba = new RispostaDBAdapter();

        Cursor ris = db.rawQuery("SELECT r.ID FROM Risposta as r WHERE r.Risposta =" +testo,null);
        if (ris == null) {
            _return = new Risposta();
            _return.setRisposta(testo);
            Call<Risposta> call = apiService.ScriviRisposta(testo);
            final Risposta final_return = _return;
            call.enqueue(new Callback<Risposta>() {
                @Override
                public void onResponse(Call<Risposta> call, Response<Risposta> response) {
                    Possiede p = new Possiede();
                    Domanda d = new Domanda();
                    p.setIdDomanda(domanda);
                    p.setIdRisposta(final_return.getId());
                    pdb.open();
                    pdb.addConnessione(d.getDomanda(), final_return.getRisposta());
                    pdb.close();
                }

                @Override
                public void onFailure(Call<Risposta> call, Throwable t) {

                }
            });
        }else {
           _return = (Risposta) rba.getRisposta(ris.getInt(0));
        }
    }

}

