package com.ifts.bfastfattorino.Business;

import com.ifts.bfastfattorino.ModelAPP.Fattorino;

public class ValutazioneFattorino {
    public String valutazione(String s) {
        //EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
        Fattorino f = cerca(s);
        String Ris = ("SELECT AVG(o.ValutazioneFatt) FROM `ordine` as o,fattorino as f"
                + "WHERE o.IDfaFK = f.ID" +
                "")/*.setParameter("f.ID", f.getId())*/;
        return Ris;
    }

    public Fattorino cerca (String id) {
        //EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
        Fattorino _return = new Fattorino();
        Integer ID = Integer.parseInt(id);
       // cerca utente
        return _return;
    }
}
