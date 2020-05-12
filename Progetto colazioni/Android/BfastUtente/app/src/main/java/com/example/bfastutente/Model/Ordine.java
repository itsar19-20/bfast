package com.example.bfastutente.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Ordine {

    @SerializedName("utente")
    private String idUtente;
    @SerializedName("bar")
    private int idBar;
    @SerializedName("pagamento")
    private int idTipoPagamento;
    private int idIndirizzo;
    @SerializedName("id")
    private int id;
    @SerializedName("orario")
    private String orario;
    @SerializedName("note")
    private String note;
    @SerializedName("data")
    private Date data;
    @SerializedName("confermato")
    private byte confermato;
    @SerializedName("valutazioneFattorino")
    private float valutazioneFattorino;

    @Override
    public String toString() {
        return "Ordine{" +
                "id=" + id +
                ", idUtente='" + idUtente + '\'' +
                ", idBar=" + idBar +
                ", idTipoPagamento=" + idTipoPagamento +
                ", idIndirizzo=" + idIndirizzo +
                ", orario='" + orario + '\'' +
                ", note='" + note + '\'' +
                ", data=" + data +
                ", confermato=" + confermato +
                ", valutazioneFattorino=" + valutazioneFattorino +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdUtente() {
        return idUtente;
    }

    public void setIdUtente(String idUtente) {
        this.idUtente = idUtente;
    }

    public int getIdBar() {
        return idBar;
    }

    public void setIdBar(int idBar) {
        this.idBar = idBar;
    }

    public int getIdTipoPagamento() {
        return idTipoPagamento;
    }

    public void setIdTipoPagamento(int idTipoPagamento) {
        this.idTipoPagamento = idTipoPagamento;
    }

    public int getIdIndirizzo() {
        return idIndirizzo;
    }

    public void setIdIndirizzo(int idIndirizzo) {
        this.idIndirizzo = idIndirizzo;
    }

    public String getOrario() {
        return orario;
    }

    public void setOrario(String orario) {
        this.orario = orario;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public byte getConfermato() {
        return confermato;
    }

    public void setConfermato(byte confermato) {
        this.confermato = confermato;
    }

    public float getValutazioneFattorino() {
        return valutazioneFattorino;
    }

    public void setValutazioneFattorino(float valutazioneFattorino) {
        this.valutazioneFattorino = valutazioneFattorino;
    }


}
