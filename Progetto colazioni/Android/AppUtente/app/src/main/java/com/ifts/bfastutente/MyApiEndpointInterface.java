package com.ifts.bfastutente;

import com.ifts.bfastutente.ModelAPP.Utente;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/login")
    Call<Utente> login(@Query("mail")String mail, @Query("password") String pwd);

    @GET("/registrazione")
    Call<Utente> registrazione(@Query("username")String usrnm, @Query("password") String pwd,@Query("username")String usrnm, @Query("password") String pwd);

    @GET("/CancellazioneUtente")
    Call<Utente> Cancellazione(@Query("mail")String mail, @Query("password") String pwd);

    @GET("/ConfermaPosizione")


    @GET("/ConfermaMail")
    Call<Utente> ConfermaMail(@Query("mail")String mail);


    @GET("/CambioMail")
    Call<Utente> CambioMail(@Query("mail")String mail, @Query("mail") String mail);


    @GET("/CambioPassword")
    Call<Utente> CambioPassword(@Query("password")String pass, @Query("copassword") String copass);


    @GET("/PasswordDimenticata")
    Call<Utente> login(@Query("mail")String mail);


    @GET("/Ordini")


    @GET("/SelezioneBar")


    @GET("/SelezionePosizione")


    @GET("/SelezioneProdotti")


    @GET("/ScriviDomanda")


    @GET("/ScriviRisposta")


    @GET("CercaDomanda")


}