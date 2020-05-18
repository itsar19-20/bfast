package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

public class Menu {

    private String idProdotto;
    private int idBar;
    @SerializedName("id")
    private int id;
    @SerializedName("disponibilita")
    private byte disponibilita;


    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", idBar=" + idBar +
                ", idProdotto='" + idProdotto + '\'' +
                ", disponibilita=" + disponibilita +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
    }

    public String getIdProdotto() {
        return idProdotto;
    }

    public void setIdProdotto(String idProdotto) {
        this.idProdotto = idProdotto;
    }

    public byte getDisponibilita() {
        return disponibilita;
    }

    public void setDisponibilita(byte disponibilita) {
        this.disponibilita = disponibilita;
    }

}
