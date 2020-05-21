package com.example.bfastfattorino.Model;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Ordine {

    private int id;
    private String idutfk;
    @SerializedName("fattorino")
    private int idfatfk;
    private int idbarfk;
    private int idtifk;
    private int idpofk;
    private int idinfk;
    private String orario;
    private String note;
    private Date data;
    private Byte confermato;
    private float valutazione;

    public int getId() {return this.id; }
    public void setId(int id) {this.id = id; }
    public String getIdutfk () {return this.idutfk; }
    public void setIdutfk (String idutfk) {this.idutfk = idutfk; }
    public int getIdfatfk() {return this.idfatfk; }
    public void setIdfatfk(int idfatfk) {this.idfatfk = idfatfk; }
    public int getIdbarfk() {return this.idbarfk; }
    public void setIdbarfk(int idbarfk) {this.idbarfk = idbarfk; }
    public int getIdtifk() {return this.idtifk; }
    public void setIdtifk(int idtifk) {this.idtifk = idtifk; }
    public int getIdpofk() {return this.idpofk; }
    public void setIdpofk(int idpofk) {this.idpofk = idpofk; }
    public int getIdinfk() {return this.idinfk; }
    public void setIdinfk(int idinfk) {this.idinfk = idinfk; }
    public String getOrario() {return this.orario; }
    public void setOratio(String orario) {this.orario = orario; }
    public String getNote() {return this.note; }
    public void setNote(String note) {this.note = note; }
    public Date getData() {return this.data; }
    public void setData (Date data) {this.data = data; }
    public byte getConfermato () {return this.confermato; }
    public void setConfermato(byte confermato) {this.confermato = confermato; }
    public float getValutazione() {return this.valutazione; }
    public void setValutazione(float valutazione) {this.valutazione = valutazione; }

}

