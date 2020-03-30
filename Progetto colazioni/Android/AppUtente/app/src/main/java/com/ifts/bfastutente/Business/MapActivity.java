package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ifts.bfastutente.Adapter.BarDBAdapter;
import com.ifts.bfastutente.ModelAPP.Indirizzo;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionBar;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    BarDBAdapter bdb = new BarDBAdapter(this);
    Marker markerUtente;
    private Ordini or;
    private SessionBar session;
    private int id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        or.creazione();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.mapView);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        List<Integer> indirizzo = new ArrayList<>();
        indirizzo = bdb.getIdIndirizzo();
        for (int i = 0; i < indirizzo.size(); i ++) {
            Indirizzo in = null;
            in.setId(indirizzo.get(i));
            double latitude = in.getX();
            double longitude= in.getY();
            MarkerOptions markerOptions = new MarkerOptions();
            LatLng location = new LatLng(latitude, longitude);
            markerOptions.position(location);
            mMap.addMarker(markerOptions);
        }
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {

                if(markerUtente == null){

                }else{
                    markerUtente.remove();
                }
                markerUtente = mMap.addMarker(new MarkerOptions().position(latLng).title("Posizione selezionata"));
                double lat = latLng.latitude;
                double lng = latLng.longitude;
                ConfermaPosizione cp = new ConfermaPosizione();
                cp.Visualizza(lat,lng);
            }
        });
    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        session.setIDBar(id);
        or.Selezionabar();
        Intent bar = new Intent(MapActivity.this, ListaProdotti.class);
        startActivity(bar);
        return false;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
