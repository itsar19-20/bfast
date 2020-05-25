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
                String Copassword = etcopass.getText().toString();        Integer id = session.getIDfatt();
                Fattorino _return = null;
                _return= (Fattorino) udba.getUserLogin(id);

                if (password.equals(Copassword)) {
                    _return.setPassword(password);
                    Call<Fattorino> call = apiService.CambioPassword(password);
                    final Fattorino final_return1 = _return;
                    call.enqueue(new Callback<Fattorino>() {
                        @Override
                        public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                            udba.open();
                            udba.updateUser(final_return1.getMail(), final_return1.getPassword(), final_return1.getNome(), final_return1.getCognome(), final_return1.getId(), final_return1.getNascità());
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
