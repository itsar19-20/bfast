package com.ifts.bfastutente.ModelAPP;

public class Sceglie {

    private int id;
    private int idIndirizzo;
    private String idUtente;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdIndirizzo() {
        return idIndirizzo;
    }

    public void setIdIndirizzo(int idIndirizzo) {
        this.idIndirizzo = idIndirizzo;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    @Override
    public String toString() {
        return "Sceglie{" +
                "id=" + id +
                ", idIndirizzo=" + idIndirizzo +
                ", idUtente='" + idUtente + '\'' +
                '}';
    }

}
