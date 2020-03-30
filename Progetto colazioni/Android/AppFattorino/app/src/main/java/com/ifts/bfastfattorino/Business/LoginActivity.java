package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.Utils.BfastFattorinoApi;
import com.ifts.bfastfattorino.R;
import com.ifts.bfastfattorino.Sessioni.SessionFat;
import com.ifts.bfastfattorino.Utils.RetrofitUtils;

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
        setContentView(R.layout.activity_main);
        TextView tv = findViewById(R.id.textView4);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setContentView(R.layout.activity_registrazione);
            }
        });
        b1 = findViewById(R.id.Registrazione);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText text1 = findViewById(R.id.editText2);
                EditText text2 = findViewById(R.id.editText3);
                Call<Fattorino> call = apiService.login(text1.toString(), text2.toString());
                call.enqueue(new Callback<Fattorino>() {

                    @Override
                    public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                        int id = Integer.parseInt(text1.toString());
                        Fattorino f = (Fattorino) fdb.getUserLogin(id);
                        session.setIDfatt(id);
                        Intent cambia = new Intent(LoginActivity.this, ConfigurazioneOnline.class);
                        startActivity(cambia);
                    }

                    @Override
                    public void onFailure(Call<Fattorino> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Errore nel login", Toast.LENGTH_LONG).show();
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
                Intent cambia = new Intent(LoginActivity.this, ControlloID.class);
                startActivity(cambia);
            }
        });
    }
}
