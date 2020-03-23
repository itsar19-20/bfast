package com.ifts.bfastutente.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastutente.Adapter.PossiedeDBAdapter;
import com.ifts.bfastutente.ModelAPP.Domanda;
import com.ifts.bfastutente.ModelAPP.Possiede;
import com.ifts.bfastutente.ModelAPP.Risposta;

public class ScriviRisposta extends AppCompatActivity {

    public Risposta registrazione(int domanda, String testo) {
        Risposta _return = null;
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

    private void scrivi(int domanda, Risposta _return) {
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

