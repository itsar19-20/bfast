package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Chiedeu;
import model.Domanda;
import model.Utente;
import utils.JPAUtil;

public class ScriviDomanda {

	
	public Domanda registrazione(String testo,String mail) throws ParseException
	{
		Domanda _return = null;
        int chk=0;
        int numero = 0;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		try {
			Query Ris = em.createNativeQuery("SELECT d.ID FROM Domanda as d \\r\\n\" + \r\n" + 
					"WHERE d.domanda = "+testo+"");		
			numero = (Integer)Ris.getSingleResult();
		}catch (Exception e)
        {
            chk=-1;
             System.out.println("HibernateException Occured!!"+e);
            e.printStackTrace();
	    }
	if(chk==0)
	{
		_return = em.find(Domanda.class, numero);
		return _return;
	}
	else
	{
	    _return = new Domanda();
	    em.getTransaction().begin();
	    _return.setDomanda(testo);
	    em.getTransaction().commit();
	    Utente u = em.find(Utente.class, mail);
	    Chiedeu cu = new Chiedeu();
	    em.getTransaction().begin();
	    cu.setUtente(u);
	    cu.setDomanda(_return);
	    em.getTransaction().commit();
	    return _return;
	}

	}

}