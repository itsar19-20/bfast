package com.ifts.bfastutente.Sessioni;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionProdotto {
    private SharedPreferences prefs;

    public SessionProdotto(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setNomeProdotto(String mail) {
        prefs.edit().putString("mail", mail).commit();
    }

    public String getNomeProdotto() {
        String mail = prefs.getString("mail","");
        return mail;
    }

}
