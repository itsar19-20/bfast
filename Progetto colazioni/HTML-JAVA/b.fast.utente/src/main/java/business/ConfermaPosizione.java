package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Indirizzo;
import utils.JPAUtil;

public class ConfermaPosizione {
	
	public int Visualizza(String via,String civico,String cap,String citta) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = (Query) em.createQuery("SELECT i.ID FROM inditizzo as i\r\n" + 
				"WHERE i.via = Via AND i.civico = Civico AND i.citta = Citta AND i.CAP = cap").setParameter("Via", via).setParameter("Civico", civico)
				.setParameter("cap", cap).setParameter("Citta", citta).getSingleResult();
		if(Ris == null) {
			Indirizzo i = new Indirizzo();
			i.setCap(cap);
			i.setCitta(citta);
			i.setCivico(civico);
			i.setVia(via);	
			return i.getId();
		}else {
			int i = Ris.getFirstResult();
			return i;
		}
	}
}
