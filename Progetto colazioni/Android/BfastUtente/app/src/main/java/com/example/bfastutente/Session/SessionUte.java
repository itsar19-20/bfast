package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionUte {

    private SharedPreferences prefs;
    private SharedPreferences.Editor editor;

    public SessionUte(Context cntx) {
        prefs = cntx.getSharedPreferences("Session",Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setMailUt(String mail) {
        prefs.edit().putString("mail", mail).apply();
    }

    public String getMailUt() {
        String mail = prefs.getString("mail","");
        return mail;
    }

}