package com.example.bfastutente.Utils;

import com.google.gson.annotations.SerializedName;

public class OrdineJson {

    @SerializedName("id")
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
