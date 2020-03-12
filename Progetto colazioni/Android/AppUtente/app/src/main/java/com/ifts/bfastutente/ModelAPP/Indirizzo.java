package com.ifts.bfastutente.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class Indirizzo {

    @SerializedName("id")
    private int id;
    @SerializedName("via")
    private String via;
    @SerializedName("civico")
    private String civico;
    @SerializedName("citta")
    private String citta;
    @SerializedName("cap")
    private String cap;

    @Override
    public String toString() {
        return "Indirizzo{" +
                "id=" + id +
                ", via='" + via + '\'' +
                ", civico='" + civico + '\'' +
                ", citta='" + citta + '\'' +
                ", cap='" + cap + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public String getCivico() {
        return civico;
    }

    public void setCivico(String civico) {
        this.civico = civico;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getCap() {
        return cap;
    }

    public void setCap(String cap) {
        this.cap = cap;
    }
}
