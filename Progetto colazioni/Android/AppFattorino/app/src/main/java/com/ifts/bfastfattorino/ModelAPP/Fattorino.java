package com.ifts.bfastfattorino.ModelAPP;

import java.io.Serializable;
import java.util.Date;

public class Fattorino implements Serializable {

    private int id;

    private String cognome;

    private String mail;

    private Date nascità;

    private String nome;

    private String password;

    private float valutazione;

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

    public Date getNascità() {
        return this.nascità;
    }

    public void setNascità(Date nascità) {
        this.nascità = nascità;
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
