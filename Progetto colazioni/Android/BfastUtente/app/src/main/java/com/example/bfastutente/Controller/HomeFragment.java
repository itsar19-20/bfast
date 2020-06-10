package com.example.bfastutente.Controller;


import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.bfastutente.Adapter.BarDBAdapter;
import com.example.bfastutente.Adapter.IndirizzoDBAdapter;
import com.example.bfastutente.Model.Indirizzo;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionProdotto;
import com.example.bfastutente.Session.SessionSomma;
import com.example.bfastutente.Session.SessionUte;
import com.example.bfastutente.Utils.BarJson;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.OrdineJson;
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
    SessionOrdine sessionOrdine;
    SessionSomma sessionSomma;
    Dialog myDialog;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment fragment = (SupportMapFragment)getChildFragmentManager().findFragmentById(R.id.mapView);
        myDialog = new Dialog(getContext());
        fragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mMap = googleMap;
        CameraUpdate point = CameraUpdateFactory.newLatLng(new LatLng(45, 9));
        mMap.moveCamera(point);
        mMap.setMinZoomPreference(7);
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
            public void onMapClick(final LatLng latLng) {
                if(markerUtente == null){

                }else{
                    markerUtente.remove();
                }
                markerUtente = mMap.addMarker(new MarkerOptions().position(latLng).title("Posizione selezionata"));
                sessionUte = new SessionUte(getActivity());
                String mail = sessionUte.getMailUt();
                Call<OrdineJson> call = apiService.Inizio(mail);
                call.enqueue(new Callback<OrdineJson>(){
                    @Override
                    public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getActivity(), "Errore di sistema! Ordini non disponibili", Toast.LENGTH_SHORT).show();
                        }else{
                            OrdineJson o = response.body();
                            int id = Integer.parseInt(o.getId());
                            sessionOrdine = new SessionOrdine(getActivity());
                            sessionOrdine.setIDOrd(id);
                        }
                    }

                    @Override
                    public void onFailure(Call<OrdineJson> call, Throwable t) {
                        Toast.makeText(getActivity(), "Problema col server", Toast.LENGTH_SHORT).show();
                    }
                });
                double x = latLng.latitude;
                double y = latLng.longitude;

                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                            if(marker.getTitle().equals("Posizione selezionata")){
                                Toast.makeText(getActivity(), "Seleziona un bar e non la tua attuale posizione", Toast.LENGTH_SHORT).show();
                            }else{
                                ShowPopup(getView(),marker);
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
            Intent selezione = new Intent(getActivity(), ListaProdotti.class);
            startActivity(selezione);
        }catch(Exception e) {
            Toast.makeText(getActivity(), "Non hai selezionato nessun bar", Toast.LENGTH_SHORT).show();
            System.out.println("HibernateException Occured!!" + e);
            e.printStackTrace();
        }
      return false;
    }

    public void ShowPopup(View v, final Marker marker) {
        TextView txtclose;
        Button btnSel;
        myDialog.setContentView(R.layout.popupbar);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        final TextView tbar = myDialog.findViewById(R.id.TvxBar);
        final TextView tval = myDialog.findViewById(R.id.TvxVal);
        Call<BarJson> popup = apiService.barpopup(marker.getTitle());
        popup.enqueue(new Callback<BarJson>() {
            @Override
            public void onResponse(Call<BarJson> call, Response<BarJson> response) {
                if (!response.isSuccessful()) {
                    Toast.makeText(getActivity(), "Errore di sistema! Ordini non disponibili", Toast.LENGTH_SHORT).show();
                }else{
                    BarJson bj = response.body();
                    marker.setTitle(String.valueOf(bj.getId()));
                    tbar.setText(bj.getNome());
                    tval.setText(String.valueOf(bj.getVal()));
                }
            }

            @Override
            public void onFailure(Call<BarJson> call, Throwable t) {

            }
        });
        btnSel = (Button) myDialog.findViewById(R.id.btnvalid);
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });

        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        Window window = myDialog.getWindow();
        WindowManager.LayoutParams wlp = window.getAttributes();

        wlp.gravity = Gravity.BOTTOM;
        window.setAttributes(wlp);
        myDialog.show();
        btnSel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session = new SessionBar(getActivity());
                sessionSomma = new SessionSomma(getActivity());
                session.setIDInd(Integer.valueOf(marker.getTitle()));
                sessionSomma.setSomma(0);
                Call<OrdineJson> callBar = apiService.SelezioneBar(String.valueOf(sessionOrdine.getIDOrd()),marker.getTitle());
                callBar.enqueue(new Callback<OrdineJson>() {
                    @Override
                    public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(getActivity(), "Impossibile selezionare il bar", Toast.LENGTH_SHORT).show();
                        }else{
                            sessionProdotto = new SessionProdotto(getActivity());
                            sessionProdotto.confermarto(0);
                            LatLng pos = markerUtente.getPosition();
                            String x = String.valueOf(pos.latitude);
                            String y = String.valueOf(pos.longitude);
                            Call<OrdineJson> callPos = apiService.SelezionePosizione(sessionUte.getMailUt(),String.valueOf(sessionOrdine.getIDOrd()),String.valueOf(x),String.valueOf(y));
                            callPos.enqueue(new Callback<OrdineJson>() {
                                @Override
                                public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                                    if (!response.isSuccessful()) {
                                        Toast.makeText(getActivity(), "Impossibile trovare la posizione", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Intent selezione = new Intent(getView().getContext(), ListaProdotti.class);
                                        startActivity(selezione);
                                    }
                                }

                                @Override
                                public void onFailure(Call<OrdineJson> call, Throwable t) {
                                    Toast.makeText(getActivity(), "Impossibile collegari al server", Toast.LENGTH_SHORT).show();
                                }
                            });
                        }
                    }

                    @Override
                    public void onFailure(Call<OrdineJson> call, Throwable t) {
                        Toast.makeText(getActivity(), "Problema col server", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });

    }

}