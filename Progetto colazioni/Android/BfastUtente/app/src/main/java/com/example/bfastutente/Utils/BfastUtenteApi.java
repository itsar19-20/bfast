package com.example.bfastutente.Utils;

import com.example.bfastutente.Model.Bar;
import com.example.bfastutente.Model.Domanda;
import com.example.bfastutente.Model.Indirizzo;
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
    Call<Utente> ConfermaMail(@Query("mail") String mail);


    @GET("CambioMail")
    Call<Utente> CambioMail(@Query("mail") String mail);


    @GET("CambioPassword")
    Call<Utente> CambioPassword(@Query("password") String pass);


    @GET("PasswordDimenticata")
    Call<Utente> PasswordDimeticata(@Query("password") String pass);


    @GET("TuttiBar")
    Call<List<Bar>> UpdateBar();


    @GET("TuttiProdotti")
    Call<List<Prodotto>> UpdateProdotto();


    @GET("TuttiIndirizzi")
    Call<List<Indirizzo>> UpdateIndirizzi();


    @GET("ProdottiBar")
    Call<List<Prodotto>> ProdottiBar(@Query("id") String id);

    @GET("Inzio")
    Call<Ordine> Inizio(@Query("mail") String idut);

    @GET("SelezioneBar")
    Call<Ordine> ordiniBa(@Query("ordine")String idor,@Query("bar") String idba);

    @POST("SelezionePosizione")
    @FormUrlEncoded
    Call<Indirizzo> SelezionePosizione(@Query("ordine")String id,@Query("x") String x, @Query("y") String y);


    @GET("ScriviDomanda")
    Call<Domanda> ScriviDomanda(@Query("testo") String testo);


    @GET("TrovaRisposta")
    Call<Risposta> TrovaRisposta(@Query("testo") String testo);


    @GET("ScriviRisposta")
    Call<Risposta> ScriviRisposta(@Query("testo") String testo);


    @GET("ValutazioneFattorino")
    Call<Ordine> ValutazioneFattorino(@Query("valutazioneFattorino") String valutazione);

   /*
    @POST("Carrello")
    @FormUrlEncoded
    Call<Ordine> ordiniCa(@Query("orario") String orario, @Query("pagamento") int id, @Query("note") String note);

    @POST("SelezioneProdotto")
    @FormUrlEncoded
    Call<Contiene> SelezioneProdotto(@Query("ordine") int id, @Query("prodotto") String nome, @Query("quantita") int quantita);


*/

}