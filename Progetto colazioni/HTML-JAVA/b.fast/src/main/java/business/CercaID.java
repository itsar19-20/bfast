package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;


public class CercaID {

	public Bar cambio(String id) {
		Bar _return; 
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Integer ID = Integer.parseInt(id);
		_return = em.find(Bar.class, ID);
		return _return;
	}
	
}