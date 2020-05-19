package business;

import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;

import model.Ordine;
import utils.JPAUtil;

public class ValutazioneFattorino {
	
	public Ordine cerca(String ID,String val2) {
		Ordine _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer id = Integer.parseInt(ID);
		_return = em.find(Ordine.class, id);
		float val = Float.valueOf(val2);
		em.getTransaction().begin();
		_return.setValutazioneFatt(val);
		em.getTransaction().commit();
		return _return;
	}
	
}
