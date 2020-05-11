package com.example.bfastutente.Utils;

import com.example.bfastutente.Model.Bar;
import com.example.bfastutente.Model.Prodotto;
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

    @GET("UpdateBar")
    Call<List<Bar>> UpdateBar();

    @GET("UpdateProdotto")
    Call<List<Prodotto>> UpdateProdotto();

   /* @POST("OrdiniUtente")
    @FormUrlEncoded
    Call<Ordine> ordiniUt(@Query("id") Integer id, @Query("utente") String idut);

    @POST("OrdiniBar")
    @FormUrlEncoded
    Call<Ordine> ordiniBa(@Query("bar") Integer id);

    @POST("OrdiniCarrello")
    @FormUrlEncoded
    Call<Ordine> ordiniCa(@Query("orario") String orario, @Query("pagamento") int id, @Query("note") String note);

    @POST("SelezionePosizione")
    @FormUrlEncoded
    Call<Indirizzo> SelezionePosizione(@Query("x") double x, @Query("y") double y);

    @POST("ConfermaPosizione")
    @FormUrlEncoded
    Call<Indirizzo> ConfermaPosizione(@Query("id") int posizione);

    @POST("SelezioneProdotti")
    @FormUrlEncoded
    Call<Contiene> SelezioneProdotto(@Query("ordine") int id, @Query("prodotto") String nome, @Query("quantita") int quantita);

    @POST("ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("testo") String testo);

    @POST("ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("testo") String testo);

    @GET("ValutazioneFattorino")
    @FormUrlEncoded
    Call<Ordine> ValutazioneFattorino(@Query("valutazioneFattorino") float valutazione);

*/

}