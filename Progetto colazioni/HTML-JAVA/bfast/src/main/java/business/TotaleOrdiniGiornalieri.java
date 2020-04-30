package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import utils.JPAUtil;

public class TotaleOrdiniGiornalieri {
	
	public int  Visualizza(int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = em.find(Bar.class, id);
		Query Ris = em.createQuery("SELECT COUNT(*) FROM ordine as o, bar as b\r\n" + 
					"WHERE DAY(o.data) = DAY(CURRENT_DATE) and :b.id = o.IDbarFK  AND o.Confermato = 1").setParameter("b.id", b.getId());
		return Ris.executeUpdate();
		}
	
}
