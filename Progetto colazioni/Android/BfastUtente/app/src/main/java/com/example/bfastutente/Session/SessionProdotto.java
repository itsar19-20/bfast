package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionProdotto {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionProdotto(Context cntx) {
        prefs = cntx.getSharedPreferences("SessionProdotto",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setNomeProdotto(String mail) {
        prefs.edit().putString("prodotto", mail).apply();
    }

    public String getNomeProdotto() {
        String mail = prefs.getString("mail","");
        return mail;
    }

}
