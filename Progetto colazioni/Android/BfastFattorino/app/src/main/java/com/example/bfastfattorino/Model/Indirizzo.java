package com.example.bfastfattorino.Model;

import com.google.gson.annotations.SerializedName;

public class Indirizzo {

    @SerializedName("id")
    private int id;
    @SerializedName("x")
    double x;
    @SerializedName("y")
    private double y;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
