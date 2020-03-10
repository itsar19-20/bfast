package com.ifts.bfastutente.ModelAPP;

public class Utente {
    private String email;
    private String nome;
    private String cognome;
    private int telefono;
    private String pass;
    private long nascita;

    @Override
    public String toString() {
        return "Utente{" +
                "email='" + email + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", telefono=" + telefono +
                ", pass='" + pass + '\'' +
                ", nascita=" + nascita +
                '}';
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public long getNascita() {
        return nascita;
    }

    public void setNascita(long nascita) {
        this.nascita = nascita;
    }
}
