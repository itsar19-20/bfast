package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

public class Possiede {

    private int idDomanda;
    private int idRisposta;
    @SerializedName("id")
    private int id;

    @Override
    public String toString() {
        return "Possiede{" +
                "id=" + id +
                ", idDomanda=" + idDomanda +
                ", idRisposta=" + idRisposta +
                '}';
    }

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

    public int getIdRisposta() {
        return idRisposta;
    }

    public void setIdRisposta(int idRisposta) {
        this.idRisposta = idRisposta;
    }

}
