package com.ifts.bfastfattorino.Business;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.ifts.bfastfattorino.Adapter.PosizioneFattorinoDBAdapter;
import com.ifts.bfastfattorino.R;

import java.util.ArrayList;
import java.util.List;

    public class ViaggioFattorino extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

        private GoogleMap mMap;
        PosizioneFattorinoDBAdapter bdb = new PosizioneFattorinoDBAdapter();
        Marker markerUtente;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_homepage);
            // Obtain the SupportMapFragment and get notified when the map is ready to be used.
            SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                    .findFragmentById(R.id.mapView);
            mapFragment.getMapAsync(this);
        }

        @Override
        public void onMapReady(GoogleMap googleMap) {
            mMap = googleMap;

            googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

                @Override
                public void onMapClick(LatLng latLng) {

                }
            });
        }


        @Override
        public boolean onMarkerClick(Marker marker) {
            return false;
        }

        @Override
        public void onPointerCaptureChanged(boolean hasCapture) {

        }
    }
