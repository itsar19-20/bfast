package com.ifts.bfastutente.ModelAPP;

public class Domanda {

    private int id;
    private String domanda;

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

    @Override
    public String toString() {
        return "Domanda{" +
                "id=" + id +
                ", domanda='" + domanda + '\'' +
                '}';
    }
}
