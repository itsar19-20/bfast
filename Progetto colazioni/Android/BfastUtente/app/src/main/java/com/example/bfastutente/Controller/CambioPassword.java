package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Adapter.UserDBAdapter;
import com.example.bfastutente.Model.Utente;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionUte;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CambioPassword extends AppCompatActivity {
        private SessionUte session;
        BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
        UserDBAdapter udba = new UserDBAdapter(this);
         @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
             setContentView(R.layout.activity_cambiopassword);
        final EditText etpass = findViewById(R.id.ETmail);
        final EditText etcopass = findViewById(R.id.ETnome);
        final String password = etpass.getText().toString();
        String Copassword = etcopass.getText().toString();
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
                                     Intent cambia = new Intent(CambioPassword.this, MapActivity.class);
                                     startActivity(cambia);
                                 }
                                 @Override
                                 public void onFailure(Call<Utente> call, Throwable t) {
                                     Toast.makeText(CambioPassword.this, "Errore nella creazione", Toast.LENGTH_LONG).show();
                                 }
                             });
            }
        }


    }

