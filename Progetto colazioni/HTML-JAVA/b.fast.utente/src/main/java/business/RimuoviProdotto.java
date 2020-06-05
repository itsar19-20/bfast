package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Contiene;
import utils.JPAUtil;

public class RimuoviProdotto {

	public Contiene rimuovi (String s,String nome) {
		
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Integer> id = new ArrayList<Integer>();
	    Contiene c = null;
	    try {
	    	Query Ris = em.createNativeQuery("SELECT c.ID FROM contiene as c,prodotto as p,ordine as o "
	    			+ "WHERE o.ID="+Integer.parseInt(s)+" AND p.Nome=\""+nome+"\" AND o.id=c.IDorFK AND p.Nome=c.IDprFK");
			id = Ris.getResultList();
			int count = id.size();
			for(int i=0; i<count ;i++) {
				c = em.find(Contiene.class, id.get(i));
			}
			
	    }catch (Exception e)
	    {
	        chk=-1;
	         System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
	    
		if(chk==0)
		{
			em.getTransaction().begin();
			em.remove(c);
			em.getTransaction().commit();
			return c;
		}
		else
		{
			return (null);
		}
		
	}
	
	
	public Contiene cerca (String s,String nome) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<Integer> id = new ArrayList<Integer>();
	    Contiene c = null;
	    try {
	    	Query Ris = em.createNativeQuery("SELECT c.ID FROM contiene as c,prodotto as p,ordine as o "
	    			+ "WHERE o.ID="+Integer.parseInt(s)+" AND p.Nome=\""+nome+"\" AND o.id=c.IDorFK AND p.Nome=c.IDprFK");
			id = Ris.getResultList();
			int count = id.size();
			for(int i=0; i<count ;i++) {
				c = em.find(Contiene.class, id.get(i));
			}
			
	    }catch (Exception e)
	    {
	        chk=-1;
	         System.out.println("HibernateException Occured!!"+e);
	        e.printStackTrace();
	    }
	    
        if(em!=null)
        {
             em.clear();
             em.close();
        }
		if(chk==0)
		{
			return c;
		}
		else
		{
			return (null);
		}

	}
	
}
