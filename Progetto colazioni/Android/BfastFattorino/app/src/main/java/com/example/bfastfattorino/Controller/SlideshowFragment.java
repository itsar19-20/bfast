package com.example.bfastfattorino.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.bfastfattorino.R;

public class SlideshowFragment extends Fragment {

    private TextView t1,t2,t3,t4;

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
               /* Intent mail= new Intent(getActivity(), CambioMail.class);
                startActivity(mail);*/
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent pass = new Intent(getActivity(), CambioPassword.class);
                startActivity(pass);*/
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /* Intent pass = new Intent(getActivity(), CambioPassword.class);
                startActivity(pass);*/
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pass = new Intent(getActivity(), VisualizzaValutazione.class);
                startActivity(pass);
            }
        });

    }
}
