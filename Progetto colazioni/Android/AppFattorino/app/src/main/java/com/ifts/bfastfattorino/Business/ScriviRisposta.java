package com.ifts.bfastfattorino.Business;

import androidx.appcompat.app.AppCompatActivity;

import com.ifts.bfastfattorino.ModelAPP.Domanda;
import com.ifts.bfastfattorino.ModelAPP.Possiede;
import com.ifts.bfastfattorino.ModelAPP.Risposta;

import retrofit2.http.Query;

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

    private void scrivi(int domanda,Risposta _return) {
        Possiede p = new Possiede();
       // Domanda d = Domanda, domanda;
        //p.setDomanda(d);
       // p.setRisposta(_return);
        //em.getTransaction().begin();
        //em.persist(p);
        //em.getTransaction().commit();
    }



}
}
