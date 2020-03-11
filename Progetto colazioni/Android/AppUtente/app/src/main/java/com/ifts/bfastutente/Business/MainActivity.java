package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.ModelAPP.Utente;
import com.ifts.bfastutente.R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.mapbox.mapboxsdk.maps.Style;

public class MainActivity extends AppCompatActivity {
    private MapView mapView;
    private Button b1;
    private TextView t1;
    private TextView t2;


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
        b1 = findViewById(R.id.login);
        t1 = findViewById(R.id.textView2);
        t2 = findViewById(R.id.textView3);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText text1 = findViewById(R.id.editText2);
                EditText text2 = findViewById(R.id.editText3);
                Call<Utente> call = apiService.login(text1, text2);
                call.enqueue(new Callback<Utente>() {
                    @Override
                    public void onResponse(Response<Utente> response) {
                        int statusCode = response.code();
                        User user = response.body();

                    }

                    @Override

                    public void onFailure(Throwable t) {

                        // Log error richiesta fallita

                    }

                }
            }
        })
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent reg= new Intent(MainActivity.this, RegistrazioneActivity.class);
                startActivity(reg);
            }
        })
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambia = new Intent(MainActivity.this, pswDimenticata.class);
                startActivity(cambia);
            }
        })
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
