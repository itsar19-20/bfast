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


public class CambioMail extends AppCompatActivity {
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    SessionUte sessionUte;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiomail);
        b1 = findViewById(R.id.BtnCamMail);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 EditText etemail = findViewById(R.id.username);
                 EditText etcomail = findViewById(R.id.coemail);
                 String mail = etemail.getText().toString();
                 String Comail = etcomail.getText().toString();
                if (mail.equals(Comail)) {
                    sessionUte = new SessionUte(CambioMail.this);
                    String m = sessionUte.getMailUt();
                    Call<Utente> call = apiService.CambioMail(m,mail,Comail);
                    call.enqueue(new Callback<Utente>() {
                        @Override
                        public void onResponse(Call<Utente> call, Response<Utente> response) {
                            if(response.isSuccessful()){
                                Toast.makeText(CambioMail.this, "Errore nel cambio mail", Toast.LENGTH_LONG).show();
                            }else{
                                Intent cambia = new Intent(CambioMail.this, MapActivity.class);
                                startActivity(cambia);
                            }

                        }

                        @Override
                        public void onFailure(Call<Utente> call, Throwable t) {
                            Toast.makeText(CambioMail.this, "Errore nella connessione col server", Toast.LENGTH_LONG).show();

                        }
                    });
            }
        }

    });
}
}
