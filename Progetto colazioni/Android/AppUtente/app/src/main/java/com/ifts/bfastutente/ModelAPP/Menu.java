package com.ifts.bfastutente.ModelAPP;

public class Menu {
    private int id;
    private int idBar;
    private String idProdotto;
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
