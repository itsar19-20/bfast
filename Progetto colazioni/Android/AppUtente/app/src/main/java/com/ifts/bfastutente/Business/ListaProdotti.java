package com.ifts.bfastutente.Business;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionProdotto;

import java.util.ArrayList;
import java.util.List;


class ListaProdotti extends AppCompatActivity {
    EditText etAuthor, etTitle, etBody;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    ConstraintLayout constraintLayout;
    FloatingActionButton seleziona;
    private SessionProdotto session;
    private String nome;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrazione);//schermata di lista
        setTooblar();
        EditText etNome = findViewById(R.id.ETnome);
        pdb.open();
        Bundle data = getIntent().getExtras();
        List<String> prodotto = new ArrayList<>();
        prodotto = pdb.getIdProdotto();
        for (int i = 0; i < prodotto.size(); i ++) {
            Prodotto pr = null;
            pr.setNome(prodotto.get(i));
            etNome.setText(prodotto.get(i));
            nome = data.getString("nome");
        }
        seleziona = findViewById(R.id.BtnLogin);//da vedere in base alla view
        seleziona.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.setNomeProdotto(nome);
                Intent toHome = new Intent(ListaProdotti.this, VisualizzazioneProdotto.class);
                startActivity(toHome);
            }
        });
    }



    public void setTooblar() {
        Toolbar toolbar = findViewById(R.id.toolbar_createActivity);
        setSupportActionBar(toolbar);
        Button btnSave = findViewById(R.id.btn_done_toolbarCreate);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent toHome = new Intent(ListaProdotti.this, MainActivity.class);//da aggiungere activity per carrello
                    startActivity(toHome);
            }
        });
    }

    @Override
    protected void onDestroy() {
        pdb.close();
        super.onDestroy();
    }
}
