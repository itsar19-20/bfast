package com.ifts.bfastfattorino.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.Adapter.PossiedeDBAdapter;
import com.ifts.bfastfattorino.Adapter.RispostaDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Possiede;
import com.ifts.bfastfattorino.ModelAPP.Risposta;
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

    public Risposta registrazione(final int domanda, String testo) {
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
            return _return;
        }else {
           _return = (Risposta) rba.getRisposta(ris.getInt(0));
            return _return;
        }
    }

}

