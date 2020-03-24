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

public class CambioMail extends AppCompatActivity {

    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    private SessionFat session;
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    public Fattorino cambio(String mail, String Comail) {
        Integer id = session.getIDfatt();
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);
        if (mail.equals(Comail)) {
            _return.setMail(mail);
            Call<Fattorino> call = apiService.CambioMail(mail);
            final Fattorino final_return = _return;
            call.enqueue(new Callback<Fattorino>() {
                             @Override
                             public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                                 udba.open();
                                 udba.updateUser(final_return.getMail(), final_return.getPassword(), final_return.getNome(), final_return.getCognome(), final_return.getId(), final_return.getNascità());
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