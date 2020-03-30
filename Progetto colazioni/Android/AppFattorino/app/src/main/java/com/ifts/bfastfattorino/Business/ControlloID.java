package com.ifts.bfastfattorino.Business;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.R;
import com.ifts.bfastfattorino.Sessioni.SessionFat;
import com.ifts.bfastfattorino.Utils.BfastFattorinoApi;
import com.ifts.bfastfattorino.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ControlloID extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    private SessionFat session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final EditText etid = findViewById(R.id.editText7);
        final int id = Integer.valueOf(etid.getText().toString());
        Fattorino _return = null;
        _return = (Fattorino) udba.getUserLogin(id);
        Call<Fattorino> call = apiService.ConfermoID(id);
        final Fattorino final_return = _return;
        call.enqueue(new Callback<Fattorino>() {


            @Override
            public void onResponse(Call<Fattorino> call, Response<Fattorino> response) {
                session.setIDfatt(id);
                Intent cambia = new Intent(ControlloID.this, pswDimenticata.class);
                startActivity(cambia);
            }

            @Override
            public void onFailure(Call<Fattorino> call, Throwable t) {

            }
        });
    }
}
