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

public class CambioMail extends AppCompatActivity {

    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    private SessionFat session;
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
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
                final String mail = etemail.getText().toString();
                String Comail = etcomail.getText().toString();
                session = new SessionFat(CambioMail.this);
                Integer id = session.getIDfatt();
                if (mail.equals(Comail)) {
                    Call<Fattorino> call = apiService.CambioMail(String.valueOf(id),mail,Comail);
                    call.enqueue(new Callback<Fattorino>() {
                        @Override
                        public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                            Intent pass = new Intent(CambioMail.this, DashboardActivity.class);
                            startActivity(pass);
                        }

                        @Override
                        public void onFailure(Call<Fattorino> call, Throwable t) {

                        }
                    });

                }
            }
        });
    }
}