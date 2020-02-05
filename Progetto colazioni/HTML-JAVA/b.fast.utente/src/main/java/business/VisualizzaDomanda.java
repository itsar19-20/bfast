package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Risposta;
import utils.JPAUtil;

public class VisualizzaDomanda {

	
	public Risposta registrazione(int domanda) throws ParseException
	{
		Risposta _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Query Ris = em.createQuery("SELECT p.IDriFK FROM Possiede as p,Domanda as d \r\n" + 
				"WHERE p.IDdoFK = d.ID;").setParameter("d.ID", domanda);
		_return =em.find(Risposta.class, Ris.getFirstResult());
		return _return;
	}
}
