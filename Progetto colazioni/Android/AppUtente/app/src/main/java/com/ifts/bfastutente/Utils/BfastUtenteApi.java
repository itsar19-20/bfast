package com.ifts.bfastutente.Utils;

import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Domanda;
import com.ifts.bfastutente.ModelAPP.Indirizzo;
import com.ifts.bfastutente.ModelAPP.Ordine;
import com.ifts.bfastutente.ModelAPP.Prodotto;
import com.ifts.bfastutente.ModelAPP.Risposta;
import com.ifts.bfastutente.ModelAPP.Utente;

import retrofit2.Call;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BfastUtenteApi {

    @GET("/login")
    @FormUrlEncoded
    Call<Utente> login(@Query("mail")String mail, @Query("password") String pwd);

    @GET("/registrazione")
    @FormUrlEncoded
    Call<Utente> registrazione(@Query("mail")String mail, @Query("password") String pwd,@Query("nome")String nome,
                               @Query("cognome") String cognome, @Query("data") String data, @Query("telefono") String tel);

    @GET("/CancellazioneUtente")
    @FormUrlEncoded
    Call<Utente> Cancellazione(@Query("mail")String mail, @Query("password") String pwd);


    @GET("/ConfermaMail")
    @FormUrlEncoded
    Call<Utente> ConfermaMail(@Query("mail")String mail);


    @GET("/CambioMail")
    @FormUrlEncoded
    Call<Utente> CambioMail(@Query("mail")String mail, @Query("comail") String comail);


    @GET("/CambioPassword")
    @FormUrlEncoded
    Call<Utente> CambioPassword(@Query("password")String pass, @Query("copassword") String copass);


    @GET("/PasswordDimenticata")
    @FormUrlEncoded
    Call<Utente> PasswordDimeticata(@Query("newpasswoerd")String newpass);


    @GET("/Ordini")
    @FormUrlEncoded
    Call<Ordine> ordini(@Query("orario")String orario, @Query("note")String note,@Query("data")String data,
                        @Query("confermato")String confermato,@Query("valutazioneFttorino")String valutazioneFattorino);


    @GET("/SelezioneBar")
    @FormUrlEncoded
    Call<Bar> SelezioneBar(@Query("nome")String nome, @Query("orarioApertura")String orarioApertura, @Query("orarioChiusura")String orarioChiusura,
                           @Query("valutazione")float valutazione, @Query("email")String email,
                           @Query("password")String password, @Query("fascia")float fascia);


    @GET("/SelezionePosizione")
    @FormUrlEncoded
    Call<Indirizzo> SelezionePosozione(@Query("via")String via, @Query("civico")String civico, @Query("citta")String citta,
                                       @Query("cap")String cap);


    @GET("/ConfermaPosizione")
    @FormUrlEncoded
    Call<Indirizzo> ConfermaPosizione(@Query("posizione")String posizione);


    @GET("/SelezioneProdotti")
    @FormUrlEncoded
    Call<Prodotto> SelezioneProdotto(@Query("nome")String nome, @Query("ingredienti")String ingredienti, @Query("prezzo")float prezzo,
                                     @Query("tipo")String tipo);

    @GET("/ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("testo")String testo);


    @GET("/ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("testo")String testo);


    @GET("CercaDomanda")
    @FormUrlEncoded
    Call<Domanda> CercaDomanda(@Query("domanda")String domanda);


}