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

public class CambioPassword extends AppCompatActivity {
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    public Fattorino cambio(String password, String Copassword) {
        Integer id = session.getIDfatt();
        final FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        Fattorino _return = null;
        _return= (Fattorino) udba.getUserLogin(id);

        if (password.equals(Copassword)) {
            _return.setPassword(password);
            Call<Fattorino> call = apiService.CambioPassword(password);
            final Fattorino final_return1 = _return;
            call.enqueue(new Callback<Fattorino>() {
                             @Override
                             public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                                 udba.open();
                                 udba.updateUser(final_return1.getMail(), final_return1.getPassword(), final_return1.getNome(), final_return1.getCognome(), final_return1.getId(), final_return1.getNascità());
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
