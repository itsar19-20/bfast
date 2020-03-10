package com.ifts.bfastutente.ModelAPP;

public class ChiedeUtente {

    private int id;
    private int idDomanda;
    private String utente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdDomanda() {
        return idDomanda;
    }

    public void setIdDomanda(int idDomanda) {
        this.idDomanda = idDomanda;
    }

    public String getUtente() {
        return utente;
    }

    public void setUtente(String utente) {
        this.utente = utente;
    }

    @Override
    public String toString() {
        return "ChiedeUtente{" +
                "id=" + id +
                ", idDomanda=" + idDomanda +
                ", utente='" + utente + '\'' +
                '}';
    }
}
