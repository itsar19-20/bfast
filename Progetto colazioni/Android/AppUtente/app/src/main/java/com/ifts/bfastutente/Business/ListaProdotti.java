package com.ifts.bfastutente.Business;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;

import java.util.ArrayList;
import java.util.List;


class ListaProdotti extends AppCompatActivity {
    EditText etAuthor, etTitle, etBody;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    ConstraintLayout constraintLayout;
    FloatingActionButton seleziona;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);//schermata di lista
        setTooblar();
        EditText etNome = findViewById(R.id.ETnome);
        pdb.open();
        List<String> prodotto = new ArrayList<>();
        prodotto = pdb.getIdProdotto();
        for (int i = 0; i < prodotto.size(); i ++) {
            Prodotto pr = null;
            pr.setNome(prodotto.get(i));
            etNome.setText(prodotto.get(i));
        }
        seleziona = findViewById(R.id.BtnLogin);//da vedere in base alla view
        seleziona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toHome = new Intent(ListaProdotti.this, MainActivity.class);//da aggiungere activity per carrello
                startActivity(toHome);
            }
        });
    }



    public void setTooblar() {
        Toolbar toolbar = findViewById(R.id.toolbar_createActivity);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onDestroy() {
        pdb.close();
        super.onDestroy();
    }
}
