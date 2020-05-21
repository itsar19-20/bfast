package com.example.bfastfattorino.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionFat {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionFat(Context cntx) {
        prefs = cntx.getSharedPreferences("Session",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setIDfatt(Integer id) {
        prefs.edit().putString("id", String.valueOf(id)).apply();
    }

    public int getIDfatt() {
        String id = prefs.getString("id","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }
}