package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Prodotto;
import utils.JPAUtil;

public class TuttiProdotti {
	
	public List<Prodotto> Nonpresenti(int s){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<String> nome = new ArrayList<String>();
	    List<Prodotto> pro = new ArrayList<Prodotto>();
	    try {
			Query Ris1 = em.createNativeQuery("SELECT p.Nome FROM prodotto as p " + 
					"WHERE p.Nome NOT IN(SELECT p.Nome FROM prodotto as p,menu as m,bar b WHERE m.IDprFK = p.Nome AND b.id = "+s+" AND b.id = m.IDbaFK)");
			nome = Ris1.getResultList();
	    	int count = nome.size();
	    	for(int i=0;i<count;i++) {
	    		pro.add(em.find(Prodotto.class, nome.get(i)));
	    	}
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
		    return pro;
		}
		else
		{
		    return (null);
		}
	
		}

	
	public List<Prodotto> Presenti(int id){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    List<String> nome = new ArrayList<String>();
	    List<Prodotto> pro = new ArrayList<Prodotto>();
	    try {
			Query Ris1 = em.createNativeQuery("SELECT p.Nome FROM prodotto as p,menu as m,bar b "+
					"WHERE m.IDprFK = p.Nome AND b.id = "+id+" AND b.id = m.IDbaFK");
			nome = Ris1.getResultList();
	    	int count = nome.size();
	    	for(int i=0;i<count;i++) {
	    		pro.add(em.find(Prodotto.class, nome.get(i)));
	    	}
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
		    return pro;
		}
		else
		{
		    return (null);
		}
	
		}

}