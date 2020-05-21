package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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


public class LoginActivity extends AppCompatActivity {

    FattorinoDBAdapter fdb = new FattorinoDBAdapter(this);
    private Button b1;
    private TextView t1;
    private TextView t2;
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        b1 = findViewById(R.id.BtnLog);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText text1 = findViewById(R.id.ETid);
                EditText text2 = findViewById(R.id.ETpass);
                Call<Fattorino> call = apiService.login(text1.getText().toString(), text2.getText().toString());
                call.enqueue(new Callback<Fattorino>() {

                    @Override
                    public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(LoginActivity.this, "Credenziali errate", Toast.LENGTH_LONG).show();
                        }else{
                            int id = Integer.parseInt(text1.getText().toString());
                            try{
                                Fattorino f = (Fattorino) fdb.getUserLogin(id);
                            }catch(Exception e){

                            }
                            session = new SessionFat(LoginActivity.this);
                            session.setIDfatt(id);
                            Intent cambia = new Intent(LoginActivity.this, DashboardActivity.class);
                            startActivity(cambia);
                        }

                    }

                    @Override
                    public void onFailure(Call<Fattorino> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();
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
        /*t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambia = new Intent(LoginActivity.this, ControlloID.class);
                startActivity(cambia);
            }
        });*/
    }
}
