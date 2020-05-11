package com.example.bfastutente.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Adapter.UserDBAdapter;
import com.example.bfastutente.Model.Utente;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionUte;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class pswDimenticata extends AppCompatActivity {
    private SessionUte session;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pswdimenticata);
        final EditText etpass = findViewById(R.id.ETpass);
        final EditText etcopass = findViewById(R.id.ETcopass);
        final String password = etpass.getText().toString();
        final String Copassword = etcopass.getText().toString();
        String mail = session.getMailUt();
        Utente _return = null;
        final UserDBAdapter udba = new UserDBAdapter(this);
        _return = (Utente) udba.getUserLogin(mail);
        if (password.equals(Copassword)) {
            Call<Utente> call = apiService.PasswordDimeticata(password);
            final Utente final_return = _return;
            call.enqueue(new Callback<Utente>() {
                @Override
                public void onResponse(Call<Utente> call, Response<Utente> response) {
                    udba.open();
                    udba.updateUser(final_return.getEmail(),password, final_return.getNome(), final_return.getCognome(), final_return.getTelefono(), final_return.getNascita());
                    udba.close();
                    Intent log = new Intent(pswDimenticata.this, MapActivity.class);
                    startActivity(log);
                }

                @Override
                public void onFailure(Call<Utente> call, Throwable t) {

                }
            });
        }
    }
}
