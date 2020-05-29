package com.example.bfastutente.Utils;

import com.example.bfastutente.Model.Bar;
import com.example.bfastutente.Model.Domanda;
import com.example.bfastutente.Model.Indirizzo;
import com.example.bfastutente.Model.Prodotto;
import com.example.bfastutente.Model.Risposta;
import com.example.bfastutente.Model.Utente;


import java.util.List;

import retrofit2.Call;
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
    Call<Utente> Cancellazione(@Query("mail") String mail);


    @GET("ConfermaMail")
    Call<Utente> ConfermaMail(@Query("mail") String mail);


    @GET("CambioMail")
    Call<Utente> CambioMail(@Query("imail") String imail,@Query("mail") String mail,@Query("comail") String comail);


    @GET("CambioPassword")
    Call<Utente> CambioPassword(@Query("mail") String mail,@Query("password") String pass,@Query("copassword") String copass);


    @GET("PasswordDimenticata")
    Call<Utente> PasswordDimeticata(@Query("mail") String mail,@Query("pass") String pass,@Query("copass") String copass);


    @GET("TuttiBar")
    Call<List<Bar>> UpdateBar();


    @GET("TuttiProdotti")
    Call<List<Prodotto>> UpdateProdotto();


    @GET("TuttiIndirizzi")
    Call<List<Indirizzo>> UpdateIndirizzi();


    @GET("ProdottiBar")
    Call<List<Prodotto>> ProdottiBar(@Query("id") String id);


    @POST("Inizio")
    Call<OrdineJson> Inizio(@Query("mail") String mail);


    @POST("SelezionaBar")
    Call<OrdineJson> SelezioneBar(@Query("ordine")String idor,@Query("bar") String idba);


    @POST("SelezionaProdotto")
    Call<OrdineJson> SelezioneProdotto(@Query("ordine") String id, @Query("Nome") String nome, @Query("Quantita") String quantita);


    @POST("Carrello")
    Call<OrdineJson> Carrello(@Query("ordine")String id,@Query("orario") String orario, @Query("pagamento") String idpag, @Query("note") String note);


    @POST("SelezionePosizione")
    Call<Indirizzo> SelezionePosizione(@Query("ordine")String id,@Query("x") String x, @Query("y") String y);



    @GET("ScriviDomanda")
    Call<Domanda> ScriviDomanda(@Query("testo") String testo);



    @GET("TrovaRisposta")
    Call<Risposta> TrovaRisposta(@Query("testo") String testo);



    @GET("ScriviRisposta")
    Call<Risposta> ScriviRisposta(@Query("testo") String testo);



    @GET("ValutazioneFattorino")
    Call<OrdineJson> ValutazioneFattorino(@Query("ordine")String id,@Query("valutazione") String valutazione);

    @GET("CostoProdotto")
    Call<Prodotto>  CostoProdotto(@Query("nome") String nome);

}