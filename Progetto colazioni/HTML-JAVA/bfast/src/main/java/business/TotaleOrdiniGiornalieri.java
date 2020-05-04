package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import utils.JPAUtil;

public class TotaleOrdiniGiornalieri {
	
	public int  Visualizza(int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = em.find(Bar.class, id);
        int chk=0;
        int numero = 0;
        try {
    		Query Ris = em.createQuery("SELECT COUNT(*) FROM ordine as o, bar as b\r\n" + 
					"WHERE DAY(o.data) = DAY(CURRENT_DATE) and :b.id = o.IDbarFK  AND o.Confermato = 1").setParameter("b.id", b.getId());
    		numero = (Integer)Ris.getSingleResult();
        }catch (Exception e)
        {
            chk=-1;
             System.out.println("HibernateException Occured!!"+e);
            e.printStackTrace();
	    }
		finally
		    {
		            if(em!=null)
		            {
		                 em.clear();
		                 em.close();
		            }
		    }
		if(chk==0)
		{
		    return (numero);
		}
		else
		{
		    return (0);
		}

		}
	
}
