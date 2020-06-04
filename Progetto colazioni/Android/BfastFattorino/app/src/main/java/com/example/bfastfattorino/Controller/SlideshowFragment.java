package com.example.bfastfattorino.Controller;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bfastfattorino.R;
import com.example.bfastfattorino.Session.SessionFat;
import com.example.bfastfattorino.Utils.BfastFattorinoApi;
import com.example.bfastfattorino.Utils.RetrofitUtils;
import com.example.bfastfattorino.Utils.ValutazioneFattJSON;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SlideshowFragment extends Fragment {

    private TextView t1,t2,t3,t4,t22,t11;
    Dialog myDialog;
    BfastFattorinoApi apiService = RetrofitUtils.getInstance().getBfastFattorinoApi();
    SessionFat sessionFat;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        final TextView textView = root.findViewById(R.id.TxtCambiaMail);
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        t1 = view.findViewById(R.id.TxtCambiaMail);
        t2 = view.findViewById(R.id.Txtpassword);
        t3 = view.findViewById(R.id.txtaiuto);
        t4 = view.findViewById(R.id.Txvalutazione);
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mail= new Intent(getActivity(), CambioMail.class);
                startActivity(mail);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass = new Intent(getActivity(), CambioPassword.class);
                startActivity(pass);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass = new Intent(getActivity(), ScriviDomanda.class);
                startActivity(pass);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog = new Dialog(getContext());
                myDialog.setContentView(R.layout.popupvalutazionemedia);
                TextView txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                t11 = myDialog.findViewById(R.id.Txval);
                t22 = myDialog.findViewById(R.id.TXtesto);

                sessionFat = new SessionFat(getActivity());
                Call<ValutazioneFattJSON> call = apiService.ValutazioneFattorino(String.valueOf(sessionFat.getIDfatt()));
                call.enqueue(new Callback<ValutazioneFattJSON>() {

                    @Override
                    public void onResponse(Call<ValutazioneFattJSON> call, Response<ValutazioneFattJSON> response) {
                        if(!response.isSuccessful()){
                            Toast.makeText(getActivity(), "Errore con la risposta del server ", Toast.LENGTH_LONG).show();
                        }else{
                            ValutazioneFattJSON val = response.body();
                            if (val != null) {
                                float f = val.getVal();
                                t11.setText(String.valueOf(f));
                                if (f > 0 && f < 1) {
                                    t22.setText("Malissimo se continui così ti lincenziamo");
                                }else if(f >= 1 && f< 2){
                                    t22.setText("Cerca di migliorare sei a rischio!");
                                }else if(f >= 2 && f<3){
                                    t22.setText("Devi migliorare ma il tuo lavoro risulta appena sufficiente");
                                }else if(f>=3 && f<4){
                                    t22.setText("Molto bene ma puoi ancora migliorare");
                                }else if(f>=4 && f<5){
                                    t22.setText("Ottimo lavoro siamo fieri di te");
                                }else if (f == 5){
                                    t22.setText("Aumento immediato,Contattaci subito");
                                }
                            }else{
                                t11.setText("0");
                                t22.setText("Svolgi almeno un ordine prima di consultare la media delle valutazioni");
                            }

                        }

                    }

                    @Override
                    public void onFailure(Call<ValutazioneFattJSON> call, Throwable t) {
                        Toast.makeText(getActivity(), "Errore nella comunicazione col server", Toast.LENGTH_LONG).show();
                    }

                });
            }
        });

    }
}
