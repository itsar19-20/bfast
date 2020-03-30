package com.ifts.bfastutente.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.PossiedeDBAdapter;
import com.ifts.bfastutente.Adapter.RispostaAdapter;
import com.ifts.bfastutente.ModelAPP.Domanda;
import com.ifts.bfastutente.ModelAPP.Possiede;
import com.ifts.bfastutente.ModelAPP.Risposta;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ScriviRisposta extends AppCompatActivity {
    private SQLiteDatabase db;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    final PossiedeDBAdapter pdb= new PossiedeDBAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText etdomanda = findViewById(R.id.ETmail);
        final EditText ettesto = findViewById(R.id.ETnome);
        final int domanda = Integer.parseInt(etdomanda.getText().toString());
        String testo = ettesto.getText().toString();
        Risposta _return = null;
        RispostaAdapter rba = new RispostaAdapter();

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

