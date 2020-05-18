package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

public class Sceglie {

    private int idIndirizzo;
    private String idUtente;
    @SerializedName("id")
    private int id;

    @Override
    public String toString() {
        return "Sceglie{" +
                "id=" + id +
                ", idIndirizzo=" + idIndirizzo +
                ", idUtente='" + idUtente + '\'' +
                '}';
    }


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

}
