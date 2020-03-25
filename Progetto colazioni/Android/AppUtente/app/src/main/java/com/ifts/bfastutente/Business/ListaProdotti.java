package com.ifts.bfastutente.Business;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.ProdottoDBAdapter;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.R;

import java.util.ArrayList;
import java.util.List;

class ListaProdotti extends AppCompatActivity {

    ProdottoDBAdapter pdb = new ProdottoDBAdapter();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        List<String> prodotto = new ArrayList<>();
        prodotto = pdb.getIdProdotto();
        for (int i = 0; i < prodotto.size(); i ++) {
            Prodotto pr = null;
            pr.setNome(prodotto.get(i));
        }
    }
}
