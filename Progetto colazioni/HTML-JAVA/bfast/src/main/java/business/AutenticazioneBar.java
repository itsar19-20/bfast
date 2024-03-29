package business;

import javax.persistence.EntityManager;

import model.Bar;
import utils.JPAUtil;

public class AutenticazioneBar {

	public Bar login(String id, String password) {
		Bar _return = null;
		int ID = 0;

		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		ID = Integer.parseInt(id);
		_return = em.find(Bar.class, ID);
		if (_return != null) {
			if (!password.contentEquals(_return.getPassword())) {
				_return = null;
			}
		}
		em.close();
		return _return;
	}

}
