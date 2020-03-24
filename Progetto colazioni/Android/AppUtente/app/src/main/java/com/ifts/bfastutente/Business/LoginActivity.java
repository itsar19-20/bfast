package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.UserDBAdapter;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionUte;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    final UserDBAdapter udb = new UserDBAdapter(this);
    private MapView mapView;
    private Button b1;
    private TextView t1;
    private TextView t2;
    private SessionUte session;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Mapbox.getInstance(this, "pk.eyJ1IjoiYWxleHJ1c2VpIiwiYSI6ImNrNncxNjVxcjA3NGczbHF2cWFmZXgwOWUifQ.QnAyNsLTjGpWzZqBAp2uig");
        setContentView(R.layout.activity_main);
        mapView = findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(@NonNull MapboxMap mapboxMap) {
                mapboxMap.setStyle(Style.MAPBOX_STREETS, new Style.OnStyleLoaded() {
                    @Override
                    public void onStyleLoaded(@NonNull Style style) {

                        // Map is set up and the style has loaded. Now you can add data or make other map adjustments.


                    }
                });
            }
        });
        b1 = findViewById(R.id.BtnLogin);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText text1 = findViewById(R.id.ETmail);
                EditText text2 = findViewById(R.id.ETpass);
                Call<Utente> call = apiService.login(text1.toString(), text2.toString());
                call.enqueue(new Callback<Utente>() {
                    @Override
                    public void onResponse(Call<Utente> call, Response<Utente> response) {
                        Utente u = (Utente) udb.getUserLogin(text1.toString());
                        session.setMailUt(text1.toString());
                    }

                    @Override
                    public void onFailure(Call<Utente> call, Throwable t) {
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
                Intent cambia = new Intent(LoginActivity.this, pswDimenticata.class);
                startActivity(cambia);
            }
        });
    }


    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    public void onClick(View view) {
    }
}
