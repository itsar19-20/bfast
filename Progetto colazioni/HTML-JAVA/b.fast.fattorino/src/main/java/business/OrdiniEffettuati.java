package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import model.Fattorino;
import utils.JPAUtil;

public class OrdiniEffettuati {
	
	public void storico(HttpServletRequest req) {
		String s = (String) req.getAttribute("ID");
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Fattorino f = cerca(s);
		Query Ris = em.createQuery("SELECT o.ID,o.Data,o.ValutazioneFatt,i.via,i.civico,i.cap,i.citta,p.PosXFA,p.PosYFA FROM `ordine` as o,indirizzo as i,posfatt as p,fattorino as f"
				+ "WHERE o.IDinFK = i.ID AND o.IDpoFK = p.ID AND o.IDfaFK = f.ID AND f.ID = id " + 
				"").setParameter("f.ID", f.getId());		
	}
	
	public Fattorino cerca (String id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Fattorino _return = new Fattorino();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Fattorino.class, ID);
		return _return;
	}
}

