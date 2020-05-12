package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionBar {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionBar(Context cntx) {
        prefs = cntx.getSharedPreferences("SessionBar",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setIDBar(Integer id) {
        prefs.edit().putString("id", String.valueOf(id)).apply();
    }

    public int getIDBar() {
        String id = prefs.getString("id","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }
}
