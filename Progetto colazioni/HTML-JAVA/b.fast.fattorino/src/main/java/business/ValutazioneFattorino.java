package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Fattorino;
import utils.JPAUtil;

public class ValutazioneFattorino {

	public Query valutazione(String s) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Fattorino f = cerca(s);
		Query Ris = em.createQuery("SELECT AVG(o.ValutazioneFatt) FROM `ordine` as o,fattorino as f"
				+ "WHERE o.IDfaFK = f.ID" + 
				"").setParameter("f.ID", f.getId());
		return Ris;		
	}
	
	public Fattorino cerca (String id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Fattorino _return = new Fattorino();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Fattorino.class, ID);
		return _return;
	}
}
