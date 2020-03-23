package com.ifts.bfastutente.Sessioni;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Session {

    private SharedPreferences prefs;

    public Session(Context cntx) {
        // TODO Auto-generated constructor stub
        prefs = PreferenceManager.getDefaultSharedPreferences(cntx);
    }

    public void setMailUt(String mail) {
        prefs.edit().putString("mail", mail).commit();
    }

    public static String getMailUt() {
        String mail = prefs.getString("mail","");
        return mail;
    }
}