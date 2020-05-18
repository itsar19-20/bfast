package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionProdotto {
    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionProdotto(Context cntx) {
        prefs = cntx.getSharedPreferences("SessionProdotto", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setNomeProdotto(String mail) {
        prefs.edit().putString("prodotto", mail).apply();
    }

    public String getNomeProdotto() {
        String mail = prefs.getString("prodotto", "");
        return mail;
    }

    public void confermarto(int conf) {
        prefs.edit().putInt("conf", conf).apply();
    }

    public int getConfermato() {
        int conf = prefs.getInt("conf",0);
        return conf;
    }


}
