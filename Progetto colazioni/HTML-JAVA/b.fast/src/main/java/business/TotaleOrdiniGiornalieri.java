package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;

import model.Bar;
import utils.JPAUtil;

public class TotaleOrdiniGiornalieri {
	
	public void Visualizza(HttpServletRequest req) {
		String s = (String) req.getAttribute("ID");
		Bar b = cerca(s);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT COUNT(*) as conteggio FROM ordini as o, bar as b\r\n" + 
					"WHERE DAY(o.data) = DAY(getdate()) and b.id = o.IDbarFK  o.Confermato = '1'").setParameter("b.id", b.getId());
		em.getTransaction().begin();
		em.persist(Ris);
		em.getTransaction().commit();
	}

	public Bar cerca (String id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar _return = new Bar();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Bar.class, ID);
		return _return;
	}
}
