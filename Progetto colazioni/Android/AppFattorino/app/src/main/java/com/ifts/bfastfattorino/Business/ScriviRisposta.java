package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.Adapter.FattorinoDBAdapter;
import com.ifts.bfastfattorino.Adapter.PossiedeDBAdapter;
import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Possiede;
import com.ifts.bfastfattorino.ModelAPP.Risposta;
import com.ifts.bfastfattorino.Sessioni.SessionFat;

public class ScriviRisposta extends AppCompatActivity {
    FattorinoDBAdapter udba = new FattorinoDBAdapter(this);

    public Risposta registrazione(int domanda, String testo) {
        Integer id = SessionFat.getIDfatt();
        Risposta _return = null;
        _return= (Risposta) udba.getUserLogin(id);

        //EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
       String Ris=("SELECT r.ID FROM Risposta as r \r\n" +
                "WHERE r.Risposta = \"testo\";") /*.setParameter("testo", testo)*/;
        if (Ris == null) {
            _return = new Risposta();
            _return.setRisposta(testo);

            return _return;
        }else {
           // _return =em.find(Risposta.class, Ris.getFirstResult());
            return _return;
        }
    }

    private void scrivi(int domanda,Risposta _return) {
        PossiedeDBAdapter pdb= new PossiedeDBAdapter();
        Possiede p = new Possiede();
      Domanda d = new Domanda();
        p.setIdDomanda(domanda);
         p.setIdRisposta(_return.getId());
         pdb.open();
         pdb.addConnessione(d.getDomanda(),_return.getRisposta());
         pdb.close();


    }



}

