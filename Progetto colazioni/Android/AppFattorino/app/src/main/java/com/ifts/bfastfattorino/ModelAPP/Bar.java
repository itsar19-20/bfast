package com.ifts.bfastfattorino.ModelAPP;

public class Bar {

    private int id;
    private int idIndirizzo;
    private String nome;
    private String orarioApertura;
    private String orarioChiusura;
    private float valutazione;
    private String email;
    private String password;
    private float fascia;
    
    @Override
    public String toString() {
        return "Bar{" +
                "id=" + id +
                ", idIndirizzo=" + idIndirizzo +
                ", nome='" + nome + '\'' +
                ", orarioApertura='" + orarioApertura + '\'' +
                ", orarioChiusura='" + orarioChiusura + '\'' +
                ", valutazione=" + valutazione +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", fascia=" + fascia +
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrarioApertura() {
        return orarioApertura;
    }

    public void setOrarioApertura(String orarioApertura) {
        this.orarioApertura = orarioApertura;
    }

    public String getOrarioChiusura() {
        return orarioChiusura;
    }

    public void setOrarioChiusura(String orarioChiusura) {
        this.orarioChiusura = orarioChiusura;
    }

    public float getValutazione() {
        return valutazione;
    }

    public void setValutazione(float valutazione) {
        this.valutazione = valutazione;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public float getFascia() {
        return fascia;
    }

    public void setFascia(float fascia) {
        this.fascia = fascia;
    }
}
