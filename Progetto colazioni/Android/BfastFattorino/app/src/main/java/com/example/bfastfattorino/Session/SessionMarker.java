package com.example.bfastfattorino.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionMarker {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionMarker(Context cntx) {
        prefs = cntx.getSharedPreferences("SessionMarker",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setIDBar(Integer id) {
        prefs.edit().putString("idBar", String.valueOf(id)).apply();
    }

    public int getIDBar() {
        String id = prefs.getString("idBar","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }

    public void setIDOrd(Integer id) {
        prefs.edit().putString("idOrd", String.valueOf(id)).apply();
    }

    public int getIDOrd() {
        String id = prefs.getString("idOrd","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }
}