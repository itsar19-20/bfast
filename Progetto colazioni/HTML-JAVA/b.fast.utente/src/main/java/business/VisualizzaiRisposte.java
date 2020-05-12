package business;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Risposta;
import utils.JPAUtil;

public class VisualizzaiRisposte {

	public List<Risposta> registrazione(String testo) throws ParseException
	{
        List<Risposta> lista = new ArrayList<Risposta>();
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		try {
			Query Ris = em.createNativeQuery("SELECT r.Risposta FROM Risposta as r,Domanda as d,Possiede as p\\r\\n\" + \r\n" + 
					"WHERE d.Domanda = "+testo+"AND d.ID = p.IDdoFK AND r.ID = p.IDriFK");		
			lista = Ris.getResultList();
		}catch (Exception e)
        {
             System.out.println("HibernateException Occured!!"+e);
            e.printStackTrace();
	    }
	if(!lista.isEmpty())
	{
		return lista;
	}
	else
	{
	    return (null);
	}

	}

	
}