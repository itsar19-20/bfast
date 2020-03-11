package com.ifts.bfastutente.Business;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.R;


public class RegistrazioneActivity extends AppCompatActivity {
    UtenteDBAdapter udba = new UtenteDBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button button = findViewById(R.id.BtnCreaContattto);
        final EditText etuser = findViewById(R.id.ETUsername);
        final EditText etnome = findViewById(R.id.ETNome);
        final EditText etcognome = findViewById(R.id.ETCognome);
        final EditText etpassword = findViewById(R.id.ETPassword);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Utente u = new Utente();
                    String nome=etnome.getText().toString();
                    u.setNome(nome);
                    String cognome=etcognome.getText().toString();
                    u.setNome(nome);
                    String password=etpassword.getText().toString();
                    u.setNome(nome);
                    String user=etuser.getText().toString();
                    u.setNome(nome);
                    u.setCognome(cognome);
                    u.setPass(password);
                    u.setEmail(user);
                    if (nome.length()>0 && cognome.length()>0 && password.length()>0 && user.length()>0) {
                        udba.open();
                        udba.addUser(user,password,nome,cognome);
                        udba.close();
                        Toast.makeText(RegisterActivity.this, "Creazione avvenuta per " + u.getUsername(), Toast.LENGTH_LONG).show();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Errore, compila tutti i campi", Toast.LENGTH_LONG).show();
                    }

                } catch (Exception e) {
                    Toast.makeText(RegisterActivity.this, "Errore, compila tutti i campi", Toast.LENGTH_LONG).show();
                    e.printStackTrace();
                }
            }
        });
    }
}