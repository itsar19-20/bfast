package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

public class ControlloID extends AppCompatActivity {

    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    private SessionFat session;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_controlloid);
        final EditText etid = findViewById(R.id.ETmail);
        b1 = findViewById(R.id.BtnDimenticata);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int id = Integer.valueOf(etid.getText().toString());
                Fattorino _return = null;
                Call<Fattorino> call = apiService.ConfermoID(id);
                call.enqueue(new Callback<Fattorino>() {
                    @Override
                    public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                        session = new SessionFat(ControlloID.this);
                        session.setIDfatt(id);
                        Intent cambia = new Intent(ControlloID.this, pswDimenticata.class);
                        startActivity(cambia);
                    }

                    @Override
                    public void onFailure(Call<Fattorino> call, Throwable t) {

                    }
                });
            }

        });
    }
}
