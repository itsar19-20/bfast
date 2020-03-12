package com.ifts.bfastutente.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class Prodotto {

    private int idOrdine;
    @SerializedName("nome")
    private String nome;
    @SerializedName("ingredienti")
    private String ingredienti;
    @SerializedName("prezzo")
    private float prezzo;
    @SerializedName("tipo")
    private String tipo;


    @Override
    public String toString() {
        return "Prodotto{" +
                "nome='" + nome + '\'' +
                ", ingredienti='" + ingredienti + '\'' +
                ", idOrdine=" + idOrdine +
                ", prezzo=" + prezzo +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredienti() {
        return ingredienti;
    }

    public void setIngredienti(String ingredienti) {
        this.ingredienti = ingredienti;
    }

    public int getIdOrdine() {
        return idOrdine;
    }

    public void setIdOrdine(int idOrdine) {
        this.idOrdine = idOrdine;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
