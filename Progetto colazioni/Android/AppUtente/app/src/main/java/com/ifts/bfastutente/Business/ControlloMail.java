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

public class ControlloMail extends AppCompatActivity{
    UserDBAdapter udba = new UserDBAdapter(this);
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    private SessionUte session;
    public Utente cambio(final String mail) {
            Utente _return = null;
            _return = (Utente) udba.getUserLogin("mail");
            Call<Utente> call = apiService.ConfermaMail(mail);
            final Utente final_return = _return;
            call.enqueue(new Callback<Utente>() {
                @Override
                public void onResponse(Call<Utente> call, Response<Utente> response) {
                    session.setMailUt(mail);
                }

                @Override
                public void onFailure(Call<Utente> call, Throwable t) {
                    Toast.makeText(ControlloMail.this, "Errore nel controllo", Toast.LENGTH_LONG).show();
                }
            });
            return _return;
    }
}