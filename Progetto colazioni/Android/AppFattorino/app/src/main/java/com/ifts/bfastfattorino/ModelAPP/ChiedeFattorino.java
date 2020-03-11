package com.ifts.bfastfattorino.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class ChiedeFattorino {

    @SerializedName("id")
    private int id;
    @SerializedName("domanda")
    private Domanda domanda;
    @SerializedName("fattorino")
    private Fattorino fattorino;

    @Override
    public String toString() {
        return "ChiedeFattorino{" +
                "id=" + id +
                ", domanda=" + domanda +
                ", fattorino=" + fattorino +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Domanda getDomanda() {
        return this.domanda;
    }

    public void setDomanda(Domanda domanda) {
        this.domanda = domanda;
    }

    public Fattorino getFattorino() {
        return this.fattorino;
    }

    public void setFattorino(Fattorino fattorino) {
        this.fattorino = fattorino;
    }

}