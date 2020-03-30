package com.ifts.bfastutente.Business;


import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CambioMail extends AppCompatActivity {
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    UserDBAdapter udba = new UserDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText etemail = findViewById(R.id.ETmail);
        final EditText etcomail = findViewById(R.id.ETnome);
        final String mail = etemail.getText().toString();
        String Comail = etcomail.getText().toString();
        Utente _return = null;
        _return = (Utente) udba.getUserLogin(mail);
        if (mail.equals(Comail)) {
            Call<Utente> call = apiService.CambioMail(mail);
            final Utente final_return = _return;
            call.enqueue(new Callback<Utente>() {
                @Override
                public void onResponse(Call<Utente> call, Response<Utente> response) {
                    final_return.setEmail(mail);
                    udba.open();
                    udba.updateUser(final_return.getEmail(), final_return.getPass(), final_return.getNome(), final_return.getCognome(), final_return.getTelefono(), final_return.getNascita());
                    udba.close();
                }

                @Override
                public void onFailure(Call<Utente> call, Throwable t) {
                    Toast.makeText(CambioMail.this, "Errore nel cambio mail", Toast.LENGTH_LONG).show();

                }
            });

        }
    }
}
