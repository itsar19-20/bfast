package com.ifts.bfastutente.ModelAPP;

public class Prodotto {

    private String nome;
    private String ingredienti;
    private int idOrdine;
    private float prezzo;
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
