package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.Sessioni.SessionUte;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pswDimenticata extends AppCompatActivity {
    private SessionUte session;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    public Utente cambio(final String password, String Copassword) {
        String mail = session.getMailUt();
        Utente _return = null;
        final UserDBAdapter udba = new UserDBAdapter(this);
        _return = (Utente) udba.getUserLogin(mail);
        if (password.equals(Copassword)) {
            Call<Utente> call = apiService.PasswordDimeticata(password);
            final Utente final_return = _return;
            call.enqueue(new Callback<Utente>() {
                             @Override
                             public void onResponse(Call<Utente> call, Response<Utente> response) {
                                 udba.open();
                                 udba.updateUser(final_return.getEmail(),password, final_return.getNome(), final_return.getCognome(), final_return.getTelefono(), final_return.getNascita());
                                 udba.close();
                             }

                             @Override
                             public void onFailure(Call<Utente> call, Throwable t) {

                             }
                         });
        }
        return _return;
    }
}
