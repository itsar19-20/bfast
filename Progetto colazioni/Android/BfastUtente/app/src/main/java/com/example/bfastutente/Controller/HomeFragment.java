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
import com.example.bfastutente.Adapter.IndirizzoDBAdapter;
import com.example.bfastutente.Model.Indirizzo;
import com.example.bfastutente.Model.Ordine;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionProdotto;
import com.example.bfastutente.Session.SessionUte;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.RetrofitUtils;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeFragment extends Fragment implements  OnMapReadyCallback, GoogleMap.OnMarkerClickListener  {

    private GoogleMap mMap;
    Marker markerUtente;
    MapView mp;
    Context context;
    BarDBAdapter bdb;
    IndirizzoDBAdapter idb;
    Marker MarkerBar;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    SessionBar session;
    SessionUte sessionUte;
    SessionProdotto sessionProdotto;


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
        CameraUpdate point = CameraUpdateFactory.newLatLng(new LatLng(45, 9));
        mMap.moveCamera(point);
        mMap.setMinZoomPreference(7);
        sessionUte = new SessionUte(getActivity());
        String mail = sessionUte.getMailUt();
        /* Call<Ordine> call = apiService.Inizio(mail);
        call.enqueue(new Callback<Ordine>(){
                         @Override
                         public void onResponse(Call<Ordine> call, Response<Ordine> response) {
                             if (!response.isSuccessful()) {
                                 Toast.makeText(getActivity(), "Impossibile creare l'ordine", Toast.LENGTH_SHORT).show();
                             }else{
                                 Toast.makeText(getActivity(), "Perfetto! Ordine creato", Toast.LENGTH_SHORT).show();
                             }
                         }

                         @Override
                         public void onFailure(Call<Ordine> call, Throwable t) {
                             Toast.makeText(getActivity(), "Problema col server", Toast.LENGTH_SHORT).show();
                         }
                     });*/
        context = this.getContext();
        bdb = new BarDBAdapter(context);
        idb = new IndirizzoDBAdapter(context);
        bdb.open();
        idb.open();
            Call<List<Indirizzo>> call2 = apiService.UpdateIndirizzi();
            call2.enqueue(new Callback<List<Indirizzo>>() {
                             @Override
                             public void onResponse(Call<List<Indirizzo>> call, Response<List<Indirizzo>> response) {
                                 if (!response.isSuccessful()) {
                                     Toast.makeText(getActivity(), "Non esistono bar", Toast.LENGTH_SHORT).show();
                                 }else{
                                     try {
                                         List<Indirizzo> indirizzo = response.body();
                                         for (int i = 0; i < indirizzo.size(); i++) {
                                             Indirizzo in = null;
                                             in = indirizzo.get(i);
                                             double latitude = in.getX();
                                             double longitude = in.getY();
                                             LatLng location = new LatLng(latitude, longitude);
                                             MarkerBar = mMap.addMarker(new MarkerOptions().position(location).title(String.valueOf(in.getId())));
                                         }
                                     }catch(Exception e){
                                     Toast.makeText(getActivity(), "Nessun bar attualmente disponibile", Toast.LENGTH_SHORT).show();
                                     System.out.println("HibernateException Occured!!"+e);
                                     e.printStackTrace();
                                 }
                                 }
                             }

                             @Override
                             public void onFailure(Call<List<Indirizzo>> call, Throwable t) {
                                 Toast.makeText(getActivity(), "Problema col server", Toast.LENGTH_SHORT).show();
                             }
                         });

        googleMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {

            @Override
            public void onMapClick(LatLng latLng) {
                if(markerUtente == null){

                }else{
                    markerUtente.remove();
                }
                markerUtente = mMap.addMarker(new MarkerOptions().position(latLng).title("Posizione selezionata"));

                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                            if(marker.getTitle().equals("Posizione selezionata")){
                                Toast.makeText(getActivity(), "Seleziona un bar e non la tua attuale posizione", Toast.LENGTH_SHORT).show();
                            }else{
                                session = new SessionBar(getActivity());
                                int id = Integer.parseInt(marker.getTitle());
                                session.setIDInd(id);
                                sessionProdotto = new SessionProdotto(getActivity());
                                sessionProdotto.confermarto(0);
                                Intent selezione = new Intent(getView().getContext(), ListaProdotti.class);
                                startActivity(selezione);
                            }
                        return false;
                    }
                });

            }
        });

    }


    @Override
    public boolean onMarkerClick(Marker marker) {
        session.setIDInd(Integer.parseInt(marker.getTitle()));
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