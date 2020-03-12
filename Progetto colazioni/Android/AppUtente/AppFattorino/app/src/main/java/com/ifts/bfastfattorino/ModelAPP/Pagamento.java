package com.ifts.bfastfattorino.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class Pagamento {

    @SerializedName("id")
    private int id;
    @SerializedName("tipo")
    private String tipo;

    @Override
    public String toString() {
        return "Pagamento{" +
                "id=" + id +
                ", tipo='" + tipo + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


}
