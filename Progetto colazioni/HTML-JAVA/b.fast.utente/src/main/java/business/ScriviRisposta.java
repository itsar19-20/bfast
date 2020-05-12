package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Chiedeu;
import model.Domanda;
import model.Possiede;
import model.Risposta;
import model.Utente;
import utils.JPAUtil;

public class ScriviRisposta {

	
	public Risposta registrazione(String testo,int id) throws ParseException
	{
		Risposta _return = null;
        int chk=0;
        int numero = 0;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		try {
			Query Ris = em.createNativeQuery("SELECT r.ID FROM Risposta as r \\r\\n\" + \r\n" + 
					"WHERE r.risposta = "+testo+"");		
			numero = (Integer)Ris.getSingleResult();
		}catch (Exception e)
        {
            chk=-1;
             System.out.println("HibernateException Occured!!"+e);
            e.printStackTrace();
	    }
	if(chk==0)
	{
		_return = em.find(Risposta.class, numero);
		return _return;
	}
	else
	{
	    _return = new Risposta();
	    em.getTransaction().begin();
	    _return.setRisposta(testo);
	    em.getTransaction().commit();
	    Domanda d = em.find(Domanda.class, id);
	    Possiede p = new Possiede();
	    em.getTransaction().begin();
	    p.setDomanda(d);
	    p.setRisposta(_return);
	    em.getTransaction().commit();
	    return _return;
	}

	}

}