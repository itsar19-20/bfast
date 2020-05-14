package com.example.bfastutente.Utils;

import com.example.bfastutente.Model.Bar;
import com.example.bfastutente.Model.Domanda;
import com.example.bfastutente.Model.Ordine;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.Model.Risposta;
import com.example.bfastutente.Model.Utente;


import java.util.List;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface BfastUtenteApi {

    @GET("login")
    Call<Utente> login(@Query("mail") String mail, @Query("password") String pwd);

    @GET("registrazione")
    Call<Utente> registrazione(@Query("nome") String nome, @Query("cognome") String cognome, @Query("nascita") String data,
                               @Query("telefono") String tel,@Query("mail") String mail, @Query("pass") String pwd,@Query("copass")String copass );

    @POST("CancellazioneUtente")
    @FormUrlEncoded
    Call<Utente> Cancellazione(@Query("mail") String mail);


    @GET("ConfermaMail")
    @FormUrlEncoded
    Call<Utente> ConfermaMail(@Query("mail") String mail);


    @GET("CambioMail")
    @FormUrlEncoded
    Call<Utente> CambioMail(@Query("mail") String mail);


    @GET("CambioPassword")
    @FormUrlEncoded
    Call<Utente> CambioPassword(@Query("password") String pass);


    @GET("PasswordDimenticata")
    @FormUrlEncoded
    Call<Utente> PasswordDimeticata(@Query("password") String pass);

    @GET("TuttiBar")
    Call<List<Bar>> UpdateBar();

    @GET("TuttiProdotti")
    Call<List<Prodotto>> UpdateProdotto();

    @GET("ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("testo") String testo);

    @GET("TrovaRisposta")
    @FormUrlEncoded
    Call<Risposta> TrovaRisposta(@Query("testo") String testo);

    @GET("ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("testo") String testo);

    @GET("ValutazioneFattorino")
    @FormUrlEncoded
    Call<Ordine> ValutazioneFattorino(@Query("valutazioneFattorino") float valutazione);

   /* @POST("Inzio")
    @FormUrlEncoded
    Call<Ordine> ordiniUt(@Query("utente") String idut);

    @POST("SelezioneBar")
    @FormUrlEncoded
    Call<Ordine> ordiniBa(@Query("bar") Integer id);

    @POST("Carrello")
    @FormUrlEncoded
    Call<Ordine> ordiniCa(@Query("orario") String orario, @Query("pagamento") int id, @Query("note") String note);

    @POST("SelezioneProdotto")
    @FormUrlEncoded
    Call<Contiene> SelezioneProdotto(@Query("ordine") int id, @Query("prodotto") String nome, @Query("quantita") int quantita);

    @POST("SelezionePosizione")
    @FormUrlEncoded
    Call<Indirizzo> SelezionePosizione(@Query("x") double x, @Query("y") double y);

*/

}