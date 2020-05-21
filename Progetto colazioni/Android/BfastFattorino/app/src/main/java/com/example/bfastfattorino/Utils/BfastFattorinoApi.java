package com.example.bfastfattorino.Utils;

import com.example.bfastfattorino.Model.Fattorino;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BfastFattorinoApi {


    @GET("login")
    Call<Fattorino> login(@Query("ID") String id,
                          @Query("password") String pwd);

    @GET("registrazione")
    Call<Fattorino> registrazione(@Query("mail") String mail, @Query("password") String pwd, @Query("nome") String nome,
                                  @Query("cognome") String cognome, @Query("data") String data);


    @GET("OrdiniDaFare")
    Call<List<OrdineJSON>> OrdiniDaFare();

    @GET("OrdiniEffettuati")
    Call<List<OrdineJSON>> OrdiniEffettuati(@Query("ID")String id);

    @POST("CancellazioneFattorino")
    @FormUrlEncoded
    Call<Fattorino> Cancellazione(@Field("id") int id);


    @POST("CambioMail")
    @FormUrlEncoded
    Call<Fattorino> CambioMail(@Query("mail") String mail);


    @POST("CambioPassword")
    @FormUrlEncoded
    Call<Fattorino> CambioPassword(@Query("password") String pass);


    @POST("PasswordDimenticata")
    @FormUrlEncoded
    Call<Fattorino> PasswordDimenticata(@Query("id") int id);




    @POST("ConfermaID")
    @FormUrlEncoded
    Call<Fattorino> ConfermoID(@Query("fattorino") int id);




}

/*    @POST("ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("idDomanda") String idDomanda);


    @POST("ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("idRisposta") String idRisposta);

    @POST("ConfermaOrdine")
    @FormUrlEncoded
    Call<Ordine> ConfermaOrdine(@Query("fattorino") int id);*/