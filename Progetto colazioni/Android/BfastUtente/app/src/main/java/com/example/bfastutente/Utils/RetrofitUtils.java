package com.example.bfastutente.Utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.Date;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitUtils {
    Gson gson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
        public Date deserialize(JsonElement json, Type typeofT, JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsLong());
        }
    }).create();

    private static RetrofitUtils instance = null;
    public static final String BASE_URL = "http://192.168.1.246:8080/b.fast.utente/";  //controllate il vostro ip nel prompt
    private BfastUtenteApi Bfast;
    public static RetrofitUtils getInstance() {
        if (instance == null) {
            instance = new RetrofitUtils();
        }
        return instance;
    }

    private RetrofitUtils() {
        buildRetrofit();
    }

    private void buildRetrofit() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        this.Bfast = retrofit.create(BfastUtenteApi.class);
    }

    public BfastUtenteApi getBfastUtenteApi() {
        return this.Bfast;
    }
}