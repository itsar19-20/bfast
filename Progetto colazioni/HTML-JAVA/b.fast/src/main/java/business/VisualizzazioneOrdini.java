package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import model.Bar;
import utils.JPAUtil;

public class VisualizzazioneOrdini {
	
	public void storico(HttpServletRequest req) {
		String s = (String) req.getAttribute("ID");
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = cerca(s);
		Query Ris = em.createQuery("SELECT o.ID,o.Data,o.ValutazioneFatt,i.via,i.civico,i.cap,i.citta,p.PosXFA,p.PosYFA FROM `ordine` as o,indirizzo as i,posfatt as p,bar as b"
				+ "WHERE o.IDinFK = i.ID AND o.IDpoFK = p.ID AND o.IDfaFK = b.ID AND b.ID = id " + 
				"").setParameter("id", b.getId());		
	}
	
	public Bar cerca (String id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar _return = new Bar();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Bar.class, ID);
		return _return;
	}
}

