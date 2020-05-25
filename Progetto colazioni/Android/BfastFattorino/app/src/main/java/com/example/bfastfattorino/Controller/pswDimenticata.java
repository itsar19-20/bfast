package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class pswDimenticata extends AppCompatActivity {
    private SessionFat session;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pswdimenticata);

        final FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
        b1 = findViewById(R.id.BtnDimenticata);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText etpass = findViewById(R.id.ETpass);
                EditText etcopass = findViewById(R.id.ETconpass);
                String password = etpass.getText().toString();
                String Copassword = etcopass.getText().toString();
                if (password.equals(Copassword)) {
                    session = new SessionFat(pswDimenticata.this);
                    String id = String.valueOf(session.getIDfatt());
                    Call<Fattorino> call = apiService.PasswordDimenticata(id, password, Copassword);
                    call.enqueue(new Callback<Fattorino>() {
                        @Override
                        public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                            if(!response.isSuccessful()){
                                Toast.makeText(pswDimenticata.this, "Errore nel recupero della password", Toast.LENGTH_LONG).show();
                            }else{
                                Intent log = new Intent(pswDimenticata.this, DashboardActivity.class);
                                startActivity(log);
                            }

                        }

                        @Override
                        public void onFailure(Call<Fattorino> call, Throwable t) {
                            Toast.makeText(pswDimenticata.this, "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();

                        }
                    });
                }


            }

        });

    }
}
