package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button b1;
    private TextView t1;
    private TextView t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView4);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_registrazione);
            }
        });
        b1 = findViewById(R.id.login);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text1 = findViewById(R.id.editText2);
                EditText text2 = findViewById(R.id.editText3);
                Call<Fattorino> call = apiService.login(text1, text2);
                call.enqueue(new Callback<Fattorino>() {
                    @Override
                    public void onResponse(Response<Fattorino> response) {
                        int statusCode = response.code();
                        Utente user = response.body();

                    }

                    @Override
                    public void onFailure(Throwable t) {
                        // Log error richiesta fallita
                        Toast.makeText(MainActivity.this, "Errore nel login", Toast.LENGTH_LONG).show();
                    }

                }
            }
        });
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg= new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(reg);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambia = new Intent(MainActivity.this, pswDimenticata.class);
                startActivity(cambia);
            }
        });
    }
}
