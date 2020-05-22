package com.example.bfastfattorino.Controller;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.example.bfastfattorino.Model.Fattorino;
import com.example.bfastfattorino.Session.SessionFat;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pswDimenticata extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    public Fattorino cambio(final String password, String Copassword) {
        Integer id = session.getIDfatt();
        final Fattorino _return= (Fattorino) udba.getUserLogin(id);

        // cerca utente
        if (password.equals(Copassword)) {
            Call<Fattorino> call = apiService.PasswordDimenticata(id);
            call.enqueue(new Callback<Fattorino>() {
                             @Override
                             public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                                 udba.open();
                                 udba.updateUser(_return.getMail(),password,_return.getNome(),_return.getCognome(),_return.getId(),_return.getNascità());
                                 udba.close();
                                 Intent cambia = new Intent(pswDimenticata.this, DashboardActivity.class);
                                 startActivity(cambia);
                             }

                             @Override
                             public void onFailure(Call<Fattorino> call, Throwable t) {

                             }
                         });
        }
        return _return;
    }

}