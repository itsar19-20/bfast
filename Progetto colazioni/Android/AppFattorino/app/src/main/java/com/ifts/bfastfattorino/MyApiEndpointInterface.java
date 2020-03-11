package com.ifts.bfastfattorino;

import com.ifts.bfastfattorino.ModelAPP.Fattorino;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/login")
    Call<Fattorino> login(@Query("id")String id, @Query("password") String pwd);

    @GET("/registrazione")
    Call<Fattorino> registrazione(@Query("username")String usrnm, @Query("password") String pwd,@Query("username")String usrnm, @Query("password") String pwd);

    @GET("/CancellazioneFattorino")
    Call<Fattorino> Cancellazione(@Query("id")String id, @Query("password") String pwd);

    @GET("/CercaId")



    @GET("/CambioMail")
    Call<Fattorino> CambioMail(@Query("mail")String mail, @Query("mail") String mail);


    @GET("/CambioPassword")
    Call<Fattorino> CambioPassword(@Query("password")String pass, @Query("copassword") String copass);


    @GET("/PasswordDimenticata")
    Call<Fattorino> login(@Query("id")String id);


    @GET("/OrdiniEffettuati")


    @GET("/AccettazioneOrdine")


    @GET("/AndareOnline")


    @GET("/AndareOffline")


    @GET("/ChiediAiuto")


    @GET("/GestioneUtente")


    @GET("RifiutaOrdine")


}