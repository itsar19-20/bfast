package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionOrdine {
    private SharedPreferences prefs;

    public SessionOrdine(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setIDOrd(Integer id) {
        prefs.edit().putString("id", String.valueOf(id)).commit();
    }

    public int getIDOrd() {
        String id = prefs.getString("id","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }
}


