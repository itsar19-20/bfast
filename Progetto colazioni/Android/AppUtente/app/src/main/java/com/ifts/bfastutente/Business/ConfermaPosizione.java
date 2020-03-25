package com.ifts.bfastutente.Business;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.ModelAPP.Indirizzo;
import com.ifts.bfastutente.Utils.BfastUtenteApi;
import com.ifts.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ConfermaPosizione extends AppCompatActivity {

        BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    private SQLiteDatabase db;

        public int Visualizza(final double x, final double y) {

            Cursor Ris = db.rawQuery("SELECT i.ID FROM inditizzo as WHERE i.x ="+x+ " AND i.y ="+ y,null);

            if(Ris == null) {
                Indirizzo i = new Indirizzo();
                Call<Indirizzo> call = apiService.SelezionePosizione(x,y);
                call.enqueue(new Callback<Indirizzo>() {
                                 @Override
                                 public void onResponse(Call<Indirizzo> call, Response<Indirizzo> response) {

                                 }

                                 @Override
                                 public void onFailure(Call<Indirizzo> call, Throwable t) {

                                 }
                             });
                return i.getId();
            }else {
                int i = Integer.parseInt(Ris.toString());
                Call<Indirizzo> call = apiService.ConfermaPosizione(i);
                call.enqueue(new Callback<Indirizzo>() {
                    @Override
                    public void onResponse(Call<Indirizzo> call, Response<Indirizzo> response) {

                    }

                    @Override
                    public void onFailure(Call<Indirizzo> call, Throwable t) {

                    }
                });
                return i;
            }
        }
    }
