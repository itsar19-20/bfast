package com.example.bfastfattorino.Model;

public class ChiedeFattorino {

    private int id;
    private Domanda domanda;
    private Fattorino fattorino;

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