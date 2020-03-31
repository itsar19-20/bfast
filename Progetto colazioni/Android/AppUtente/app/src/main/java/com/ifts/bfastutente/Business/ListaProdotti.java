package com.ifts.bfastutente.Business;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;
import com.ifts.bfastutente.Sessioni.SessionProdotto;
import com.ifts.bfastutente.Utils.ListSampleActivity;

import java.util.ArrayList;
import java.util.List;


class ListaProdotti extends AppCompatActivity {
    EditText etAuthor, etTitle, etBody;
    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    ConstraintLayout constraintLayout;
    private SessionProdotto session;
    private ListSampleActivity prodottoCursorAdapter;
    private ListView listView;

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
        }
        prodottoCursorAdapter = new ListSampleActivity(ListaProdotti.this, pdb.fetchProdotto());
        listView.setAdapter(prodottoCursorAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Cursor cursor = (Cursor) prodottoCursorAdapter.getItem(position);
                String s = cursor.getString(0);
                session.setNomeProdotto(s);
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
