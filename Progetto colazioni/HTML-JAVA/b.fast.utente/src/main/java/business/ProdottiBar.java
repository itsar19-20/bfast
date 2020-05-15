package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Prodotto;
import utils.JPAUtil;

public class ProdottiBar {
	
	public List<Prodotto> All(String id2){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    int chk=0;
	    int id = Integer.parseInt(id2);
	    List<String> nome = new ArrayList<String>();
	    List<Prodotto> pro = new ArrayList<Prodotto>();
	    try {
			Query Ris1 = em.createNativeQuery("SELECT p.Nome FROM prodotto as p,bar as b,menu as m WHERE b.id = "+id+" AND b.id=m.IDbaFK AND p.Nome = m.IDprFK");
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


