package com.ifts.bfastutente.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class Risposta {

    @SerializedName("id")
    private int id;
    @SerializedName("risposta")
    private String risposta;

    @Override
    public String toString() {
        return "Risposta{" +
                "id=" + id +
                ", risposta='" + risposta + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

}
