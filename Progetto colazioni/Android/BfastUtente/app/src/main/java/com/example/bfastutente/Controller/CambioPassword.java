package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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
        Button b1;

         @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiopassword);
        final EditText etpass = findViewById(R.id.coemail);
        final EditText etcopass = findViewById(R.id.coemail);
         session = new SessionUte(CambioPassword.this);
             b1.setOnClickListener(new View.OnClickListener() {
                final String mail = session.getMailUt();
                final String password = etpass.getText().toString();
                final String Copassword = etcopass.getText().toString();
                @Override
                public void onClick(View v) {
                    if (password.equals(Copassword)) {
                        Call<Utente> call = apiService.CambioPassword(mail,password,Copassword);
                        call.enqueue(new Callback<Utente>() {
                            @Override
                            public void onResponse(Call<Utente> call, Response<Utente> response) {
                                if(response.isSuccessful()){
                                    Toast.makeText(CambioPassword.this, "Errore nel cambio password", Toast.LENGTH_LONG).show();
                                }else{
                                    Intent cambia = new Intent(CambioPassword.this, MapActivity.class);
                                    startActivity(cambia);
                                }

                            }
                            @Override
                            public void onFailure(Call<Utente> call, Throwable t) {
                                Toast.makeText(CambioPassword.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();
                            }
                        });
                }
            }

            });
        }


    }


