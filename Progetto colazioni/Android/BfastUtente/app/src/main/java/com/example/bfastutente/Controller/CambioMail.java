package com.example.bfastutente.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Adapter.UserDBAdapter;
import com.example.bfastutente.Model.Utente;
import com.example.bfastutente.R;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class CambioMail extends AppCompatActivity {
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    UserDBAdapter udba = new UserDBAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiomail);
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
                    Intent cambia = new Intent(CambioMail.this, MapActivity.class);
                    startActivity(cambia);
                }

                @Override
                public void onFailure(Call<Utente> call, Throwable t) {
                    Toast.makeText(CambioMail.this, "Errore nel cambio mail", Toast.LENGTH_LONG).show();

                }
            });

        }
    }
}
