package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Ordine;
import utils.JPAUtil;

public class ConfermaOrdine {

	public void Visualizza(HttpServletRequest req) {
		String s = (String) req.getAttribute("ID");
		Ordine b = cerca(s);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		b.setConfermato((byte) '1');
		em.getTransaction().begin();
		em.persist(b);
		em.getTransaction().commit();
	}

	public Ordine cerca (String id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Ordine _return = new Ordine();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Ordine.class, ID);
		return _return;
	}
	
}
