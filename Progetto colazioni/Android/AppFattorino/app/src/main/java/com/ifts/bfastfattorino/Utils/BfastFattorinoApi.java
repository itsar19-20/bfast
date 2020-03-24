package com.ifts.bfastfattorino.Utils;

import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.ModelAPP.Risposta;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BfastFattorinoApi {

    @GET("/fa")
    @FormUrlEncoded
    Call<List<Fattorino>> getFattorino();

    @GET("/login")
    @FormUrlEncoded
    Call<Fattorino> login(@Field("id") String id,
                          @Field("password") String pwd);

    @GET("/registrazione")
    @FormUrlEncoded
    Call<Fattorino> registrazione(@Field("nome")String nome,
                                  @Field("cognome")String cognome,
                                  @Field("data")String data,
                                  @Field("password")String pwd);

    @GET("/CancellazioneFattorino")
    @FormUrlEncoded
    Call<Fattorino> Cancellazione(@Field("id")int id);

    @GET("/CercaId")
    @FormUrlEncoded
    Call<Fattorino> CercaId (@Query("id")String id);



    @GET("/CambioMail")
    @FormUrlEncoded
    Call<Fattorino> CambioMail(@Query("mail")String mail);


    @GET("/CambioPassword")
    @FormUrlEncoded
    Call<Fattorino> CambioPassword(@Query("password")String pass);


    @GET("/PasswordDimenticata")
    @FormUrlEncoded
    Call<Fattorino> login(@Query("id")String id);


    @GET("ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> domanda(@Query("idDomanda")String idDomanda);


    @GET("ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> risposta(@Query("idRisposta")String idRisposta);

    /*@GET("/ChiediAiuto")
    @FormUrlEncoded
    Call<Fattorino> aiuto(@Query("")String);


   @GET("/OrdiniEffettuati")
    @FormUrlEncoded
    Call<Fattorino>


    @GET("/AccettazioneOrdine")
    @FormUrlEncoded
    Call<Fattorino>


    @GET("RifiutaOrdine")
    Call<Fattorino>



    @GET("/AndareOnline")
    Call<Fattorino>


    @GET("/AndareOffline")
    Call<Fattorino>*/

}