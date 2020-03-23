package com.ifts.bfastutente.Sessioni;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionBar {

    private SharedPreferences prefs;

    public SessionBar(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setIDBar(Integer id) {
        prefs.edit().putString("id", String.valueOf(id)).commit();
    }

    public int getIDBar() {
        String id = prefs.getString("id","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }
}
