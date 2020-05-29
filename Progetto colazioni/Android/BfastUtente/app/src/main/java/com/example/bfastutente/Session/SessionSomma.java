package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionSomma {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionSomma(Context cntx) {
        prefs = cntx.getSharedPreferences("SessionSomma",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setSomma(float id){
        prefs.edit().putString("Somma", String.valueOf(id)).apply();
    }

    public float getSomma() {
        String id = prefs.getString("Somma","0");
        float ID = Float.parseFloat(id);
        return ID;
    }
}
