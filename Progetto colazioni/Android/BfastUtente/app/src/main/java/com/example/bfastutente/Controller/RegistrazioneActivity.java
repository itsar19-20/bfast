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


public class RegistrazioneActivity extends AppCompatActivity {
    UserDBAdapter udba = new UserDBAdapter(this);
    private SessionUte session;
    final BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        Button button = findViewById(R.id.BtnLogin);
        final EditText etemail = findViewById(R.id.ETmail);
        final EditText etnome = findViewById(R.id.ETnome);
        final EditText etcognome = findViewById(R.id.ETcognome);
        final EditText etpassword = findViewById(R.id.ETpass);
        final EditText etconfermapassword = findViewById(R.id.ETcopass);
        final EditText etdatadinascita = findViewById(R.id.ETdata);
        final EditText etnumeroditelefono = findViewById(R.id.ETnumero);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Utente u = new Utente();
                    final String nome=etnome.getText().toString();
                    u.setNome(nome);
                    final String cognome=etcognome.getText().toString();
                    u.setCognome(cognome);
                    final String password=etpassword.getText().toString();
                    u.setNome(password);
                    String confermapassword=etconfermapassword.getText().toString();
                    u.setNome(confermapassword);
                    final String email=etemail.getText().toString();
                    u.setNome(email);
                    final String datadinascita=etdatadinascita.getText().toString();
                    u.setNome(datadinascita);
                    final String numeroditelefono=etnumeroditelefono.getText().toString();
                    u.setNome(datadinascita);


                    if (nome.length()>0 && cognome.length()>0 && password.length()>0 && email.length()>0 && numeroditelefono.length()<10 &&
                            datadinascita.length()>0 && password.equals(confermapassword)) {
                        Call<Utente> call = apiService.registrazione(nome,cognome,datadinascita,numeroditelefono,email,password,confermapassword);
                        call.enqueue(new Callback<Utente>() {
                                         @Override
                                         public void onResponse(Call<Utente> call, Response<Utente> response) {
                                             session.setMailUt(email);
                                             udba.open();
                                             udba.addUser(email,password,nome,cognome,numeroditelefono,datadinascita);
                                             udba.close();
                                             Intent log = new Intent(RegistrazioneActivity.this, MapActivity.class);
                                             startActivity(log);
                                         }

                                         @Override
                                         public void onFailure(Call<Utente> call, Throwable t) {
                                             Toast.makeText(RegistrazioneActivity.this, "Errore nella creazione dell'utente" , Toast.LENGTH_LONG).show();
                                         }
                                     });
                    } else {
                        Toast.makeText(RegistrazioneActivity.this, "Errore, compila tutti i campi", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(RegistrazioneActivity.this, "Impossibile effettuare la registrazione", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}