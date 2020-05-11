package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Prodotto;
import utils.JPAUtil;

public class TuttiProdotti {
	
	public List<Prodotto> All(){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Prodotto> pro = new ArrayList<Prodotto>();
	    try {
			Query Ris = em.createNativeQuery("SELECT * FROM prodotto");
			pro = Ris.getResultList();
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
		    return (pro);
		}
		else
		{
		    return (null);
		}
	
		}


}
