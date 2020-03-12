package com.ifts.bfastfattorino.Business;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.R;


public class RegistrazioneActivity extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);

        Button button = findViewById(R.id.Registrazione);
        final EditText etmail = findViewById(R.id.editText3);
        final EditText etnome = findViewById(R.id.editText7);
        final EditText etcognome = findViewById(R.id.editText8);
        final EditText etpassword = findViewById(R.id.editText3);
        final EditText etnascita = findViewById(R.id.editText6);
        final EditText etconfpass = findViewById(R.id.editText5);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Fattorino u = new Fattorino();
                    String nome=etnome.getText().toString();
                    u.setNome(nome);
                    String cognome=etcognome.getText().toString();
                    u.setCognome(cognome);
                    String password=etpassword.getText().toString();
                    u.setPassword(password);
                    String copass = etconfpass.getText().toString();

                    if (nome.length()>0 && cognome.length()>0 && password.length()>0 && user.length()>0 && copass==password) {
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