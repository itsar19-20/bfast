package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

public class Contiene {

    @SerializedName("prodotto")
    private String idProdotto;
    @SerializedName("ordine")
    private int idOrdine;
    @SerializedName("id")
    private int id;
    @SerializedName("quantita")
    private int quantita;

    @Override
    public String toString() {
        return "Contiene{" +
                "id=" + id +
                ", idProdotto='" + idProdotto + '\'' +
                ", idOrdine=" + idOrdine +
                ", quantita=" + quantita +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(String idProdotto) {
        this.idProdotto = idProdotto;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public int getQuantita() {
        return quantita;
    }

    public void setQuantita(int quantita) {
        this.quantita = quantita;
    }

}
