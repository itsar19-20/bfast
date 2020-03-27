package com.ifts.bfastutente.Utils;

import com.ifts.bfastutente.ModelAPP.Bar;
import com.ifts.bfastutente.ModelAPP.Contiene;
import com.ifts.bfastutente.ModelAPP.Domanda;
import com.ifts.bfastutente.ModelAPP.Indirizzo;
import com.ifts.bfastutente.ModelAPP.Ordine;
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
    Call<Utente> Cancellazione(@Query("mail")String mail);


    @GET("/ConfermaMail")
    @FormUrlEncoded
    Call<Utente> ConfermaMail(@Query("mail")String mail);


    @GET("/CambioMail")
    @FormUrlEncoded
    Call<Utente> CambioMail(@Query("mail")String mail);


    @GET("/CambioPassword")
    @FormUrlEncoded
    Call<Utente> CambioPassword(@Query("password")String pass);


    @GET("/PasswordDimenticata")
    @FormUrlEncoded
    Call<Utente> PasswordDimeticata(@Query("password")String pass);


    @GET("/OrdiniUtente")
    @FormUrlEncoded
    Call<Ordine> ordiniUt(@Query("id")Integer id, @Query("utente")String idut);

    @GET("/OrdiniBar")
    @FormUrlEncoded
    Call<Ordine> ordiniBa(@Query("bar")Integer id);

    @GET("/OrdiniCarrello")
    @FormUrlEncoded
    Call<Ordine> ordiniCa(@Query("orario")String orario, @Query("pagamento")int id,@Query("note")String note);

    @GET("/SelezionePosizione")
    @FormUrlEncoded
    Call<Indirizzo> SelezionePosizione(@Query("x")double x, @Query("y")double y);

    @GET("/ConfermaPosizione")
    @FormUrlEncoded
    Call<Indirizzo> ConfermaPosizione(@Query("id")int posizione);

    @GET("/SelezioneProdotti")
    @FormUrlEncoded
    Call<Contiene> SelezioneProdotto(@Query("ordine")int id, @Query("prodotto")String nome,@Query("quantita") int quantita);

    @GET("/ScriviDomanda")
    @FormUrlEncoded
    Call<Domanda> ScriviDomanda(@Query("testo")String testo);

    @GET("/ScriviRisposta")
    @FormUrlEncoded
    Call<Risposta> ScriviRisposta(@Query("testo")String testo);

    @GET("/ValutazioneFattorino")
    @FormUrlEncoded
    Call<Ordine> ValutazioneFattorino(@Query("valutazioneFattorino")float valutazione);

    @GET("/UpdateBar")
    @FormUrlEncoded
    Call List<Bar> UpdateBar();

    @GET("/UpdateProdotto")
    @FormUrlEncoded
    Call List<Prodotto> UpdateProdotto();

}