package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.example.bfastfattorino.Model.Fattorino;
import com.example.bfastfattorino.R;
import com.example.bfastfattorino.Session.SessionFat;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.RetrofitUtils;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class RegistrazioneActivity extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    private SessionFat session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        final BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
        Button button = findViewById(R.id.Registrazione);
        final EditText etmail = findViewById(R.id.Etmail);
        final EditText etnome = findViewById(R.id.ETnome);
        final EditText etcognome = findViewById(R.id.ETcognome);
        final EditText etpassword = findViewById(R.id.ETpass);
        final EditText etnascita = findViewById(R.id.ETnascita);
        final EditText etconfpass = findViewById(R.id.ETcopass);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Fattorino u = new Fattorino();
                    final String nome=etnome.getText().toString();
                    u.setNome(nome);
                    final String cognome=etcognome.getText().toString();
                    u.setCognome(cognome);
                    final String nascita=etnascita.getText().toString();
                    u.setCognome(nascita);
                    final String email=etmail.getText().toString();
                    u.setCognome(email);
                    final String password=etpassword.getText().toString();
                    u.setPassword(password);
                    String copass = etconfpass.getText().toString();

                    if (nome.length()>0 && cognome.length()>0 && password.length()>0 && copass.equals(password) && nascita.length()>0 && email.length()>0) {
                        Call<Fattorino> call = apiService.registrazione(email,password,copass,nome,cognome,nascita);
                        call.enqueue(new Callback<Fattorino>() {
                                         @Override
                                         public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                                             if(response.isSuccessful()){
                                                 Fattorino f = response.body();
                                                 try{
                                                     udba.open();
                                                     udba.addUser(email,password,nome,cognome,nascita);
                                                     udba.close();
                                                 }catch(Exception e){

                                                 }
                                                 session = new SessionFat(RegistrazioneActivity.this);
                                                 session.setIDfatt(f.getId());
                                                 Toast.makeText(RegistrazioneActivity.this, "Creazione avvenuta",Toast.LENGTH_LONG).show();
                                                 Intent cambia = new Intent(RegistrazioneActivity.this, DashboardActivity.class);
                                                 startActivity(cambia);
                                             }else{
                                                 Toast.makeText(RegistrazioneActivity.this, "Errore di connessione col server", Toast.LENGTH_LONG).show();
                                             }
                                         }

                                         @Override
                                         public void onFailure(Call<Fattorino> call, Throwable t) {
                                             Toast.makeText(RegistrazioneActivity.this, "Errore di connessione col server", Toast.LENGTH_LONG).show();
                                         }
                                     });
                    } else {
                        Toast.makeText(RegistrazioneActivity.this, "Errore, compila tutti i campi", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(RegistrazioneActivity.this, "Errore, compila tutti i campi", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}