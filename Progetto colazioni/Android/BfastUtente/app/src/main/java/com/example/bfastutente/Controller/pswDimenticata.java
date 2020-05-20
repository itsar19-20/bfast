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

public class pswDimenticata extends AppCompatActivity {
    private SessionUte session;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pswdimenticata);

        final UserDBAdapter udba = new UserDBAdapter(this);
            b1 = findViewById(R.id.BtnDimenticata);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                     EditText etpass = findViewById(R.id.ETpass);
                     EditText etcopass = findViewById(R.id.ETconpass);
                     String password = etpass.getText().toString();
                     String Copassword = etcopass.getText().toString();
                    if (password.equals(Copassword)) {
                        session = new SessionUte(pswDimenticata.this);
                        String mail = session.getMailUt();
                        Call<Utente> call = apiService.PasswordDimeticata(mail, password, Copassword);
                        call.enqueue(new Callback<Utente>() {
                            @Override
                            public void onResponse(Call<Utente> call, Response<Utente> response) {
                                if(!response.isSuccessful()){
                                    Toast.makeText(pswDimenticata.this, "Errore nel recupero della password", Toast.LENGTH_LONG).show();
                                }else{
                                    Intent log = new Intent(pswDimenticata.this, MapActivity.class);
                                    startActivity(log);
                                }

                            }

                            @Override
                            public void onFailure(Call<Utente> call, Throwable t) {
                                Toast.makeText(pswDimenticata.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();

                            }
                        });
                    }


                }

            });

    }
}
