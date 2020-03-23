package com.ifts.bfastfattorino.Sessioni;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionFat {

    private SharedPreferences prefs;

    public SessionFat(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setIDfatt(Integer id) {
        prefs.edit().putString("id", String.valueOf(id)).commit();
    }

    public int getIDfatt() {
        String id = prefs.getString("id","");
        Integer ID = Integer.parseInt(id);
        return ID;
    }
}