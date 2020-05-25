package com.example.bfastfattorino.Controller;


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
                Integer id = session.getIDfatt();
                Fattorino _return = null;
                _return = (Fattorino) udba.getUserLogin(id);
                if (mail.equals(Comail)) {
                    _return.setMail(mail);
                    Call<Fattorino> call = apiService.CambioMail(mail);
                    final Fattorino final_return = _return;
                    call.enqueue(new Callback<Fattorino>() {
                        @Override
                        public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                            udba.open();
                            udba.updateUser(final_return.getMail(), final_return.getPassword(), final_return.getNome(), final_return.getCognome(), final_return.getId(), final_return.getNascità());
                            udba.close();
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