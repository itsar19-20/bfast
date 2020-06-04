package com.example.bfastutente.Controller;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.braintreepayments.cardform.view.CardForm;
import com.example.bfastutente.Adapter.OrdineDBAdapter;
import com.example.bfastutente.Model.Ordine;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Session.SessionSomma;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.OrdineJson;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Carrello extends AppCompatActivity {

    Button b1,b2;
    TextView t1,t2,et6;
    EditText et1,et2,et3,et4,et5;
    private SessionBar sessionbar;
    private SessionOrdine sessionordine;
    private Ordine or;
    private String ora,data,note,concatenatedStarNames = "";
    private int paga,idord;
    private OrdineDBAdapter odb = new OrdineDBAdapter(this);
    private CheckBox cb1,cb2,cb3;
    BfastUtenteApi apiService = RetrofitUtils.getInstance().getBfastUtenteApi();
    SessionOrdine sessionOrdine;
    Dialog myDialog;
    Dialog prodotti;
    Dialog conferma;
    SessionSomma sessionSomma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        myDialog = new Dialog(this);
        prodotti = new Dialog(this);
        conferma = new Dialog(this);
        odb.open();

        et6 = findViewById(R.id.TXrecap);
        et6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                prodotti.setContentView(R.layout.popupcarrello);
                TextView txtclose = (TextView) prodotti.findViewById(R.id.txtclose);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        prodotti.dismiss();
                    }
                });
                TextView etcosto = prodotti.findViewById(R.id.TXcosto);
                final TextView etprodotti = prodotti.findViewById(R.id.TXprodotti);
                sessionSomma = new SessionSomma(Carrello.this);
                String totale = String.valueOf(sessionSomma.getSomma());
                etcosto.setText(totale);
                sessionOrdine = new SessionOrdine(Carrello.this);
                Call<OrdineJson> finepopup = apiService.CarrelloProdotti(String.valueOf(sessionOrdine.getIDOrd()));
                finepopup.enqueue(new Callback<OrdineJson>() {
                    @Override
                    public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                        if (!response.isSuccessful()) {
                            Toast.makeText(Carrello.this, "Impossibile visualizzare il recap", Toast.LENGTH_SHORT).show();
                        }else{
                            OrdineJson o = response.body();
                            etprodotti.setText(o.getId());
                        }
                    }

                    @Override
                    public void onFailure(Call<OrdineJson> call, Throwable t) {
                        Toast.makeText(Carrello.this, "Impossibile connettersi col server", Toast.LENGTH_SHORT).show();
                    }
                });
                prodotti.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                Window window = prodotti.getWindow();
                WindowManager.LayoutParams wlp = window.getAttributes();

                wlp.gravity = Gravity.BOTTOM;
                window.setAttributes(wlp);
                prodotti.show();
            }
        });

        final EditText et1 = findViewById(R.id.ETorario);
        final EditText et2 = findViewById(R.id.Etnote);
        cb1 = findViewById(R.id.checkbox_carta);
        cb3 = findViewById(R.id.checkbox_consegna);
        cb2 = findViewById(R.id.checkbox_paypal);
        cb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popuppagamento);
                TextView txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                CardForm cardForm = (CardForm) myDialog.findViewById(R.id.card_form);
                cardForm.cardRequired(true)
                        .expirationRequired(true)
                        .cvvRequired(true)
                        .cardholderName(CardForm.FIELD_REQUIRED)
                        .setup(Carrello.this);
                b2 = myDialog.findViewById(R.id.btnvalid);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Carrello.this, "Carta di credito accettata!", Toast.LENGTH_SHORT).show();
                        cb2.setChecked(false);
                        cb3.setChecked(false);
                        paga=1;
                        myDialog.dismiss();
                    }
                });
            }
        });
        cb2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                cb3.setChecked(false);
                paga=2;
            }
        });
        cb3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                cb1.setChecked(false);
                cb2.setChecked(false);
                paga=3;
            }
        });

        b1 = findViewById(R.id.Etconf);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ora = et1.getText().toString();
                note = et2.getText().toString();
                if(ora.equals("")){
                    Toast.makeText(Carrello.this, "Immetti l'ora", Toast.LENGTH_SHORT).show();
                }else if(!cb1.isChecked() && !cb2.isChecked() && !cb3.isChecked()) {
                    Toast.makeText(Carrello.this, "Immetti il tipo di pagamento", Toast.LENGTH_SHORT).show();
                }else{
                   sessionOrdine = new SessionOrdine(Carrello.this);
                    Call<OrdineJson> call = apiService.Carrello(String.valueOf(sessionOrdine.getIDOrd()),ora,String.valueOf(paga),note);
                    call.enqueue(new Callback<OrdineJson>() {
                                     @Override
                                     public void onResponse(Call<OrdineJson> call, Response<OrdineJson> response) {
                                         if (!response.isSuccessful()) {
                                             Toast.makeText(Carrello.this, "Impossibile completare l'ordine", Toast.LENGTH_SHORT).show();
                                         }else{
                                             try {
                                                 odb.finecarrello(data, note, paga);
                                             } catch (Exception e) {
                                                 System.out.println("HibernateException Occured!!" + e);
                                                 e.printStackTrace();
                                             }
                                             conferma.setContentView(R.layout.popupordineinviato);
                                             TextView txtclose = (TextView) conferma.findViewById(R.id.txtclose);
                                             txtclose.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     conferma.dismiss();
                                                 }
                                             });
                                             Button continua = conferma.findViewById(R.id.btnvalid);
                                             conferma.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                                             Window window = conferma.getWindow();
                                             WindowManager.LayoutParams wlp = window.getAttributes();

                                             wlp.gravity = Gravity.BOTTOM;
                                             window.setAttributes(wlp);
                                             conferma.show();
                                             continua.setOnClickListener(new View.OnClickListener() {
                                                 @Override
                                                 public void onClick(View v) {
                                                     Intent toHome = new Intent(Carrello.this, Ringraziamento.class);
                                                     startActivity(toHome);
                                                 }
                                             });
                                         }

                                     }

                                     @Override
                                     public void onFailure(Call<OrdineJson> call, Throwable t) {
                                         Toast.makeText(Carrello.this, "Impossibile connettersi col server", Toast.LENGTH_SHORT).show();
                                     }
                                 });

                }
            }
        });

    }
}
