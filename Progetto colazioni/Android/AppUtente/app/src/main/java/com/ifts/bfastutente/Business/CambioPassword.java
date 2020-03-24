package com.ifts.bfastutente.Business;

import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionUte;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CambioPassword extends AppCompatActivity {
        private SessionUte session;
        BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
        UserDBAdapter udba = new UserDBAdapter(this);
        public Utente cambio(final String password, String Copassword) {
            String mail = session.getMailUt();
            Utente _return = null;
            _return = (Utente) udba.getUserLogin(mail);
            if (password.equals(Copassword)) {
                Call<Utente> call = apiService.CambioPassword(password);
                final Utente final_return = _return;
                call.enqueue(new Callback<Utente>() {
                                 @Override
                                 public void onResponse(Call<Utente> call, Response<Utente> response) {
                                     final_return.setPass(password);
                                     udba.open();
                                     udba.updateUser(final_return.getEmail(), final_return.getPass(), final_return.getNome(), final_return.getCognome(), final_return.getTelefono(), final_return.getNascita());
                                     udba.close();
                                 }
                                 @Override
                                 public void onFailure(Call<Utente> call, Throwable t) {
                                     Toast.makeText(CambioPassword.this, "Errore nella creazione", Toast.LENGTH_LONG).show();
                                 }
                             });
            }
            return _return;
        }


    }


