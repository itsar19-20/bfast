package com.ifts.bfastfattorino;

import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Fattorino;
import com.ifts.bfastfattorino.ModelAPP.Risposta;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/login")
    Call<Fattorino> login(@Query("id")String id, @Query("password") String pwd);

    @GET("/registrazione")
    Call<Fattorino> registrazione(@Query("nome")String nome, @Query("password") String password,@Query("username")String usrnm,
                                  @Query("password") String pwd);

    @GET("/CancellazioneFattorino")
    Call<Fattorino> Cancellazione(@Query("id")String id, @Query("password") String pwd);

    @GET("/CercaId")
    Call<Fattorino> CercaId (@Query("id")String id);



    @GET("/CambioMail")
    Call<Fattorino> CambioMail(@Query("mail")String email, @Query("mail") String mail);


    @GET("/CambioPassword")
    Call<Fattorino> CambioPassword(@Query("password")String pass, @Query("copassword") String copass);


    @GET("/PasswordDimenticata")
    Call<Fattorino> login(@Query("id")String id);


    @GET("ScriviDomanda")
    Call<Domanda> domanda(@Query("idDomanda")String idDomanda);


    @GET("ScriviRisposta")
    Call<Risposta> risposta(@Query("idRisposta")String idRisposta);

    @GET("/ChiediAiuto")
    Call<Fattorino> aiuto(@Query("")String);


    @GET("/OrdiniEffettuati")
    Call<Fattorino>


    @GET("/AccettazioneOrdine")
    Call<Fattorino>


    @GET("RifiutaOrdine")
    Call<Fattorino>



    @GET("/AndareOnline")
    Call<Fattorino>


    @GET("/AndareOffline")
    Call<Fattorino>

}