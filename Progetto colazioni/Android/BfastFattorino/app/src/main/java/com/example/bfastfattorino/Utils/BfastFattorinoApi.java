package com.example.bfastfattorino.Utils;

import com.example.bfastfattorino.Model.Domanda;
import com.example.bfastfattorino.Model.Fattorino;
import com.example.bfastfattorino.Model.Indirizzo;
import com.example.bfastfattorino.Model.Risposta;

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
    Call<Fattorino> registrazione(@Query("mail") String mail, @Query("pass") String pwd,@Query("copass") String copwd,
                                  @Query("nome") String nome, @Query("cognome") String cognome, @Query("nascita") String data);


    @GET("OrdiniDaFare")
    Call<List<OrdineJSON>> OrdiniDaFare();

    @GET("OrdiniEffettuati")
    Call<List<OrdineJSON>> OrdiniEffettuati(@Query("ID")String id);

    @GET("MarkerBarUtente")
    Call<List<Indirizzo>> markerBU(@Query("bar")String idbar,@Query("ordine")String idord);

    @POST("CancellazioneFattorino")
    @FormUrlEncoded
    Call<Fattorino> Cancellazione(@Field("id") int id);


    @GET("CambioMail")
    Call<Fattorino> CambioMail(@Query("id") String id,@Query("mail") String mail,@Query("comail") String  comail);


    @GET("CambioPassword")
    Call<Fattorino> CambioPassword(@Query("id") String id,@Query("pass") String pass,@Query("copass") String copass);


    @GET("PasswordDimenticata")
    Call<Fattorino> PasswordDimenticata(@Query("id") String id,@Query("pass") String pass,@Query("copass") String copass);



    @GET("ConfermaID")
    Call<Fattorino> ConfermoID(@Query("fattorino") int id);


    @GET("ConfermaOrdine")
    Call<Fattorino> ConfermaOrdine(@Query("ordine")String ord,@Query("fattorino") String id);

    @GET("ValutazioneFattorino")
    Call<ValutazioneFattJSON> ValutazioneFattorino(@Query("id") String id);

    @GET("ValutazioneOrdine")
    Call<ValutazioneFattJSON> ValutazioneOrdine(@Query("id") String id);

    @POST("ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("idDomanda") String idDomanda);


    @POST("ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("idRisposta") String idRisposta);

}
