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

public class CancellazioneUtente extends AppCompatActivity {
        private SessionUte session;
        BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
        public Utente login() {
            String mail = session.getMailUt();
            Utente _return = null;
            final UserDBAdapter udba = new UserDBAdapter(this);
            _return = (Utente) udba.getUserLogin(mail);
            if (_return != null) {
                Call<Utente> call = apiService.Cancellazione(mail);
                final Utente final_return = _return;
                call.enqueue(new Callback<Utente>() {
                                 @Override
                                 public void onResponse(Call<Utente> call, Response<Utente> response) {
                                     udba.open();
                                     udba.deleteUserByUsername(final_return.getEmail());
                                     udba.close();
                                 }

                                 @Override
                                 public void onFailure(Call<Utente> call, Throwable t) {
                                     Toast.makeText(CancellazioneUtente.this, "Errore nella cancellazione", Toast.LENGTH_LONG).show();
                                 }
                             });
            }
            return _return;
        }

    }

