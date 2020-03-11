package com.ifts.bfastfattorino.ModelAPP;

public class Risposta {

    private int id;
    private String risposta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRisposta() {
        return risposta;
    }

    public void setRisposta(String risposta) {
        this.risposta = risposta;
    }

    @Override
    public String toString() {
        return "Risposta{" +
                "id=" + id +
                ", risposta='" + risposta + '\'' +
                '}';
    }
}
