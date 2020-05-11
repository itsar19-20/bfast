package com.example.bfastutente.Controller;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bfastutente.Adapter.BarDBAdapter;
import com.example.bfastutente.Model.Indirizzo;
import com.example.bfastutente.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment implements  OnMapReadyCallback, GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;
    Marker markerUtente;
    MapView mp;
    BarDBAdapter bdb = new BarDBAdapter(getContext());


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment fragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapView);
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mMap = googleMap;
        try {
            List<Integer> indirizzo = new ArrayList<>();
            indirizzo = bdb.getIdIndirizzo();
            for (int i = 0; i < indirizzo.size(); i ++) {
                Indirizzo in = null;
                in.setId(indirizzo.get(i));
                double latitude = in.getX();
                double longitude = in.getY();
                MarkerOptions markerOptions = new MarkerOptions();
                LatLng location = new LatLng(latitude, longitude);
                markerOptions.position(location);
                mMap.addMarker(markerOptions);
            }
        }catch(Exception e){
            Toast.makeText(getActivity(), "Nessun bar attualmente disponibile", Toast.LENGTH_SHORT).show();
            System.out.println("HibernateException Occured!!"+e);
                e.printStackTrace();
        }
        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {


                if(markerUtente == null){

                }else{
                    markerUtente.remove();
                }
                markerUtente = mMap.addMarker(new MarkerOptions().position(latLng).title("Posizione selezionata"));

            }
        });

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        try{
            Intent selezione = new Intent(getActivity(), ListaProdotti.class);// da reindirizzare al carrello
            startActivity(selezione);
        }catch(Exception e) {
            Toast.makeText(getActivity(), "Non hai selezionato nessun bar", Toast.LENGTH_SHORT).show();
            System.out.println("HibernateException Occured!!" + e);
            e.printStackTrace();
        }
      return false;
    }
}