package com.example.bfastutente.Controller;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bfastutente.Adapter.OrdineDBAdapter;
import com.example.bfastutente.Model.Ordine;
import com.example.bfastutente.R;
import com.example.bfastutente.Session.SessionBar;
import com.example.bfastutente.Session.SessionOrdine;
import com.example.bfastutente.Utils.BfastUtenteApi;
import com.example.bfastutente.Utils.OrdineJson;
import com.example.bfastutente.Utils.RetrofitUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Carrello extends AppCompatActivity {

    Button b1,b2;
    TextView t1,t2;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrello);
        myDialog = new Dialog(this);
        odb.open();

        final EditText et1 = findViewById(R.id.ETorario);
        final EditText et2 = findViewById(R.id.Etnote);
        cb1 = findViewById(R.id.checkbox_carta);
        cb3 = findViewById(R.id.checkbox_consegna);
        cb2 = findViewById(R.id.checkbox_paypal);
        cb1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                myDialog.setContentView(R.layout.popuppagamento);
                et3 = (EditText) myDialog.findViewById(R.id.Numero);
                et4 = (EditText) myDialog.findViewById(R.id.Scadenza);
                et5 = (EditText) myDialog.findViewById(R.id.CVC);
                TextView txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
                txtclose.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        myDialog.dismiss();
                    }
                });
                b2 = myDialog.findViewById(R.id.btnvalid);
                myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                myDialog.show();
                b2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(Carrello.this, "Carta di credito accettata! Schiaccia la x e completa il tuo ordine", Toast.LENGTH_SHORT).show();
                        cb2.setChecked(false);
                        cb3.setChecked(false);
                        paga=1;
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
                                             Toast.makeText(Carrello.this, "Il tuo ordine è stato completato", Toast.LENGTH_SHORT).show();

                                             try {
                                                 odb.finecarrello(data, note, paga);
                                             } catch (Exception e) {
                                                 System.out.println("HibernateException Occured!!" + e);
                                                 e.printStackTrace();
                                             }
                                             Intent ringraziamento = new Intent(Carrello.this, Ringraziamento.class);
                                             startActivity(ringraziamento);
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
