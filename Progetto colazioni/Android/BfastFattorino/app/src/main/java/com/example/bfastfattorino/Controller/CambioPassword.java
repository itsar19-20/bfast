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

public class CambioPassword extends AppCompatActivity {
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiopassword);
        final EditText etpass = findViewById(R.id.coemail);
        final EditText etcopass = findViewById(R.id.coemail);
        b1 = findViewById(R.id.BtnCamMail);
        final FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String password = etpass.getText().toString();
                String Copassword = etcopass.getText().toString();
                session = new SessionFat(CambioPassword.this);
                Integer id = session.getIDfatt();

                if (password.equals(Copassword)) {
                    Call<Fattorino> call = apiService.CambioPassword(String.valueOf(id),password,Copassword);
                    call.enqueue(new Callback<Fattorino>() {
                        @Override
                        public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                                Intent pass = new Intent(CambioPassword.this, DashboardActivity.class);
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
