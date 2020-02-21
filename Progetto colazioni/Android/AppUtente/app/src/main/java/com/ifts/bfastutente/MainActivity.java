package com.ifts.bfastutente;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


        public class MainActivity extends FragmentActivity {
            // coordinate su cui centrare la mappa
            private final LatLng CENTER_POINT=new LatLng(41.91, 12.40);

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_main);
                TextView tv = findViewById(R.id.textView2);
                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }); {
                // ottieni il controllo del fragment su cui caricare la mappa
                GoogleMap map=((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
                // centra la mappa su CENTER_POINT, con zoom 5
                map.moveCamera(CameraUpdateFactory.newLatLngZoom(CENTER_POINT, 5));
                map.setMyLocationEnabled(true);
                // livello di zoom = 10 ; durata animazione = 1000 millisecondi
                map.animateCamera(CameraUpdateFactory.zoomTo(10), 1000, null);
                map.addMarker(new MarkerOptions().position(CENTER_POINT));
                MarkerOptions markerOpt = new MarkerOptions()
                        .position(CENTER_POINT)
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_icona));
                map.addMarker(markerOpt);
                map.addMarker(new MarkerOptions()
                        .position(CENTER_POINT)
                        .title("Ecco il mio marker")
                        .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_icona))
                );
            }

            }
        }

