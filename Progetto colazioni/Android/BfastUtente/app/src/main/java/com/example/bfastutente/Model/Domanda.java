package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

public class Domanda {

    @SerializedName("id")
    private int id;
    @SerializedName("domanda")
    private String domanda;

    @Override
    public String toString() {
        return "Domanda{" +
                "id=" + id +
                ", domanda='" + domanda + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDomanda() {
        return domanda;
    }

    public void setDomanda(String domanda) {
        this.domanda = domanda;
    }


}
