package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import utils.JPAUtil;

public class OrdiniEffettuati {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT  FROM `bar` as b,menu as m WHERE m.ID = b.IDmeFK and m.Filtro = \"dolce\"\r\n" + 
				"");		
}

