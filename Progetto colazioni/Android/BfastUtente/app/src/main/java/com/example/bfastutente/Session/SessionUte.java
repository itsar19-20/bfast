package com.example.bfastutente.Session;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class SessionUte {

    private SharedPreferences prefs;

    public SessionUte(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setMailUt(String mail) {
        prefs.edit().putString("mail", mail).commit();
    }

    public String getMailUt() {
        String mail = prefs.getString("mail","");
        return mail;
    }

}