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

public class ControlloMail extends AppCompatActivity {
    UserDBAdapter udba = new UserDBAdapter(this);
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    private SessionUte session;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlamail);
        final EditText etemail = findViewById(R.id.ETmail);
        b1 = findViewById(R.id.BtnDimenticata);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String mail = etemail.getText().toString();
                Utente _return = null;
                Call<Utente> call = apiService.ConfermaMail(mail);
                call.enqueue(new Callback<Utente>() {
                    @Override
                    public void onResponse(Call<Utente> call, Response<Utente> response) {
                        session = new SessionUte(ControlloMail.this);
                        session.setMailUt(mail);
                        Intent cambia = new Intent(ControlloMail.this, pswDimenticata.class);
                        startActivity(cambia);
                    }

                    @Override
                    public void onFailure(Call<Utente> call, Throwable t) {
                        Toast.makeText(ControlloMail.this, "Errore nel controllo", Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


    }
}