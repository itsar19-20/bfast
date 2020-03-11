package com.ifts.bfastutente;

import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Domanda;
import com.ifts.bfastutente.ModelAPP.Indirizzo;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.ModelAPP.Risposta;
import com.ifts.bfastutente.ModelAPP.Utente;
import com.mapbox.mapboxsdk.style.light.Position;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MyApiEndpointInterface {

    @GET("/login")
    Call<Utente> login(@Query("mail")String mail, @Query("password") String pwd);

    @GET("/registrazione")
    Call<Utente> registrazione(@Query("mail")String mail, @Query("password") String pwd,@Query("nome")String nome,
                               @Query("cognome") String cognome, @Query("data") String data, @Query("copassword") String copass);

    @GET("/CancellazioneUtente")
    Call<Utente> Cancellazione(@Query("mail")String mail, @Query("password") String pwd);


    @GET("/ConfermaMail")
    Call<Utente> ConfermaMail(@Query("mail")String mail);


    @GET("/CambioMail")
    Call<Utente> CambioMail(@Query("mail")String mail, @Query("comail") String comail);


    @GET("/CambioPassword")
    Call<Utente> CambioPassword(@Query("password")String pass, @Query("copassword") String copass);


    @GET("/PasswordDimenticata")
    Call<Utente> PasswordDimeticata(@Query("newpasswoerd")String newpass);


    @GET("/Ordini")
    Call<Ordine> ordini(@Query("orario")String orario, @Query("note")String note,@Query("data")String data,
                        @Query("confermato")String confermato,@Query("valutazioneFttorino")String valutazioneFattorino);


    @GET("/SelezioneBar")
    Call<Bar> SelezioneBar(@Query("nome")String nome, @Query("orarioApertura")String orarioApertura, @Query("orarioChiusura")String orarioChiusura,
                           @Query("valutazione")float valutazione, @Query("email")String email,
                           @Query("password")String password, @Query("fascia")float fascia);


    @GET("/SelezionePosizione")
    Call<Indirizzo> SelezionePosozione(@Query("via")String via, @Query("civico")String civico, @Query("citta")String citta,
                                       @Query("cap")String cap);


    @GET("/ConfermaPosizione")
    Call<Indirizzo> ConfermaPosizione(@Query("posizione")String posizione);


    @GET("/SelezioneProdotti")
    Call<Prodotto> SelezioneProdotto(@Query("nome")String nome, @Query("ingredienti")String ingredienti, @Query("prezzo")float prezzo,
                                     @Query("tipo")String tipo);

    @GET("/ScriviDomanda")
    Call<Domanda> ScriviDomanda(@Query("testo")String testo);


    @GET("/ScriviRisposta")
    Call<Risposta> ScriviRisposta(@Query("testo")String testo);


    @GET("CercaDomanda")
    Call<Domanda> CercaDomanda(@Query("domanda")String domanda);


}