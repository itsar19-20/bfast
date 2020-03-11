package com.ifts.bfastfattorino.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class Possiede {

    @SerializedName("id")
    private int id;
    private int idDomanda;
    private int idRisposta;

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
