package com.ifts.bfastutente.Business;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.R;


public class RegistrazioneActivity extends AppCompatActivity {
    UserDBAdapter udba = new UserDBAdapter(this);

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
                    String nome=etnome.getText().toString();
                    u.setNome(nome);
                    String cognome=etcognome.getText().toString();
                    u.setCognome(cognome);
                    String password=etpassword.getText().toString();
                    u.setNome(password);
                    String confermapassword=etconfermapassword.getText().toString();
                    u.setNome(confermapassword);
                    String email=etemail.getText().toString();
                    u.setNome(email);
                    String datadinascita=etdatadinascita.getText().toString();
                    u.setNome(datadinascita);
                    String numeroditelefono=etnumeroditelefono.getText().toString();
                    u.setNome(datadinascita);


                    if (nome.length()>0 && cognome.length()>0 && password.length()>0 && email.length()>0 && numeroditelefono.length()>10 &&
                            datadinascita.length()>0 && password==confermapassword) {
                        udba.open();
                        udba.addUser(email,password,nome,cognome,numeroditelefono,datadinascita);
                        udba.close();
                        Toast.makeText(RegistrazioneActivity.this, "Creazione avvenuta per " , Toast.LENGTH_LONG).show();
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