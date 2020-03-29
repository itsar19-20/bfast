package com.ifts.bfastfattorino.Utils;

import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.ModelAPP.Ordine;
import com.ifts.bfastfattorino.ModelAPP.Risposta;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BfastFattorinoApi {


    @POST("login")
    @FormUrlEncoded
    Call<Fattorino> login(@Field("id") String id,
                          @Field("password") String pwd);

    @POST("registrazione")
    @FormUrlEncoded
    Call<Fattorino> registrazione(@Query("mail")String mail, @Query("password") String pwd,@Query("nome")String nome,
                                  @Query("cognome") String cognome, @Query("data") String data);

    @POST("CancellazioneFattorino")
    @FormUrlEncoded
    Call<Fattorino> Cancellazione(@Field("id")int id);


    @POST("CambioMail")
    @FormUrlEncoded
    Call<Fattorino> CambioMail(@Query("mail")String mail);


    @POST("CambioPassword")
    @FormUrlEncoded
    Call<Fattorino> CambioPassword(@Query("password")String pass);


    @POST("PasswordDimenticata")
    @FormUrlEncoded
    Call<Fattorino> PasswordDimenticata(@Query("id")int id);


    @POST("ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("idDomanda")String idDomanda);


    @POST("ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("idRisposta")String idRisposta);

    @POST("ConfermaOrdine")
    @FormUrlEncoded
    Call<Ordine> ConfermaOrdine(@Query("fattorino")int id);


}