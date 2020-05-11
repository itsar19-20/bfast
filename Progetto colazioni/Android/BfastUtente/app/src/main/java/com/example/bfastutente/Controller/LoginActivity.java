package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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

public class LoginActivity extends AppCompatActivity {

    final UserDBAdapter udb = new UserDBAdapter(this);
    private Button b1;
    private TextView t1;
    private TextView t2;
    private SessionUte sessione;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    UserDBAdapter dbAdapter = null;
    Utente utente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.BtnLogin);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText text1 = findViewById(R.id.ETmail);
                final EditText text2 = findViewById(R.id.ETpass);
                final String mail = text1.getText().toString();
                String pass = text2.getText().toString();
                Call<Utente> call = apiService.login(mail, pass);
                call.enqueue(new Callback<Utente>() {
                    @Override
                    public void onResponse(Call<Utente> call, Response<Utente> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(LoginActivity.this, "Credenziali errate", Toast.LENGTH_SHORT).show();
                        }else{
                           // sessione.setMailUt(mail);
                            Intent log = new Intent(LoginActivity.this, MapActivity.class);
                            startActivity(log);
                        }
                    }

                    @Override
                    public void onFailure(Call<Utente> call, Throwable t) {
                        try {
                            utente = (Utente) dbAdapter.getUserLogin(text1.getText().toString());
                            if (utente.getPass().contentEquals(text2.getText().toString())) {
                                Intent log = new Intent(LoginActivity.this, MapActivity.class);
                                startActivity(log);
                            } else {
                                Toast.makeText(LoginActivity.this, "Password Errato", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e) {
                            System.out.println("onFailure"+call);
                            Toast.makeText(LoginActivity.this, "Collegamento non funzionante e utente non trovato", Toast.LENGTH_SHORT).show();
                        }
                    }

                });
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg= new Intent(LoginActivity.this, RegistrazioneActivity.class);
                startActivity(reg);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambia = new Intent(LoginActivity.this, ControlloMail.class);
                startActivity(cambia);
            }
        });
    }

    public void onClick(View view) {
    }
}
