package com.ifts.bfastfattorino.Business;


import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Sessioni.SessionFat;
import com.ifts.bfastfattorino.Utils.BfastFattorinoApi;
import com.ifts.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CancellazioneFattorino extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    public Fattorino canc() {
        Integer id = session.getIDfatt();
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);

        final FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        //cerca fattorino
        if (_return != null) {
            Call<Fattorino> call = apiService.Cancellazione(id);
            final Fattorino final_return = _return;
            call.enqueue(new Callback<Fattorino>() {
                             @Override
                             public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                                 udba.open();
                                 udba.deleteFattorino(final_return.getId());
                                 udba.close();
                             }

                             @Override
                             public void onFailure(Call<Fattorino> call, Throwable t) {

                             }
                         });

        }
        return _return;
    }

}
