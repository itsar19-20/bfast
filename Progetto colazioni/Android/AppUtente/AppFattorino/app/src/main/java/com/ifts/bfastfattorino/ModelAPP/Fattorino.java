package com.ifts.bfastfattorino.ModelAPP;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Date;

public class Fattorino implements Serializable {

    @SerializedName("id")
    private int id;
    @SerializedName("cognome")
    private String cognome;
    @SerializedName("mail")
    private String mail;
    @SerializedName("nacita")
    private Date nascita;
    @SerializedName("nome")
    private String nome;
    @SerializedName("password")
    private String password;
    @SerializedName("valutazione")
    private float valutazione;

    @Override
    public String toString() {
        return "Fattorino{" +
                "id=" + id +
                ", cognome='" + cognome + '\'' +
                ", mail='" + mail + '\'' +
                ", nascita=" + nascita +
                ", nome='" + nome + '\'' +
                ", password='" + password + '\'' +
                ", valutazione=" + valutazione +
                '}';
    }

    public Fattorino() {
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCognome() {
        return this.cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public Date getNascita() {
        return this.nascita;
    }

    public void setNascita(Date nascita) {
        this.nascita = nascita;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getValutazione() {
        return this.valutazione;
    }

    public void setValutazione(float valutazione) {
        this.valutazione = valutazione;
    }

}
