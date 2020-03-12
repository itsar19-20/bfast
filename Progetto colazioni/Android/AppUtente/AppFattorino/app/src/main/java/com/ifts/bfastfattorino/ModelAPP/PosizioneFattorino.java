package com.ifts.bfastfattorino.ModelAPP;

import com.google.gson.annotations.SerializedName;

public class PosizioneFattorino {

    @SerializedName("id")
    private int id;
    @SerializedName("posXFA")
    private double posXFA;
    @SerializedName("posYFA")
    private double posYFA;

    @Override
    public String toString() {
        return "PosizioneFattorino{" +
                "id=" + id +
                ", posXFA=" + posXFA +
                ", posYFA=" + posYFA +
                '}';
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPosXFA() {
        return this.posXFA;
    }

    public void setPosXFA(double posXFA) {
        this.posXFA = posXFA;
    }

    public double getPosYFA() {
        return this.posYFA;
    }

    public void setPosYFA(double posYFA) {
        this.posYFA = posYFA;
    }


}