package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

public class Prodotto {

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
