package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import model.Bar;
import model.Ordine;
import utils.JPAUtil;
import utils.OrdiniUtil;

public class TotaleOrdiniConfermare {
	
	public long  Visualizza(int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
        int chk=0;
        long numero = 0;
		Bar b = em.find(Bar.class, id);
		try {
			Query Ris = em.createNativeQuery("SELECT COUNT(*)FROM ordine as o, bar as b\r\n" + 
					"WHERE DAY(o.data) = MONTH(CURRENT_DATE) AND b.id ="+b.getId()+"  AND b.id= o.IDbarFK and o.Confermato = 0 ");
			numero = (Long)Ris.getSingleResult();
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

	
	public OrdiniUtil[] PagVisualizza(int id){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = em.find(Bar.class, id);
		List<Integer> listid = new ArrayList<Integer> (); 
		List<String> listora = new ArrayList<String> (); 
		List<String> listnote = new ArrayList<String> (); 
		List<Ordine> lista = new ArrayList<Ordine> ();
		int chk = 0;
		try {
			em.getTransaction().begin();
			Query Ris = em.createNativeQuery("SELECT o.ID FROM ordine as o, bar as b\r\n" + 
					"WHERE b.ID = "+b.getId()+" AND b.ID = o.IDbarFK and o.Confermato = 0");
			Query Ris2 = em.createNativeQuery("SELECT o.Orario FROM ordine as o, bar as b\r\n" + 
					"WHERE b.ID = "+b.getId()+" AND b.ID = o.IDbarFK and o.Confermato = 0");
			Query Ris3 = em.createNativeQuery("SELECT o.Note FROM ordine as o, bar as b\r\n" + 
					"WHERE b.ID = "+b.getId()+" AND b.ID = o.IDbarFK and o.Confermato = 0");
			listid = Ris.getResultList(); 
			listora = Ris2.getResultList();
			listnote = Ris3.getResultList();
			em.getTransaction().commit();
		}catch (Exception e){
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
    if(lista.isEmpty())
    {
        return (null);
    }
    else
    {
    	OrdiniUtil[] ou = new OrdiniUtil[lista.size()];
    	for(int i : listid) {
    		ou[i]= new OrdiniUtil();
    		ou[i].setId(listid.get(i));
        	ou[i].setIngredienti(ingredientiquant(em,b,ou[i].getId()));
        	ou[i].setOrario(listora.get(i));
        	ou[i].setNote(listnote.get(i));
    	}
    	return ou;
    }
}
else
{
    return (null);
}

	}

	private String ingredientiquant(EntityManager em,Bar b,int id) {
		int chk=0;
		List<Integer> listquan = new ArrayList<Integer> (); 
		List<String> listing = new ArrayList<String> ();
		try {
			em.getTransaction().begin();
			Query Ris = em.createNativeQuery("SELECT p.Nome FROM ordine as o, bar as b,contiene as c,prodotto as p\r\n" + 
					"WHERE o.ID = c.IDorFK AND p.Nome = c.IDprFK AND o.ID = "+id+" AND b.ID = "+b.getId()+" AND b.ID = o.IDbarFK and o.Confermato = 0");
			Query Ris2 = em.createNativeQuery("SELECT c.Quantita FROM ordine as o, bar as b,contiene as c\r\n" + 
					"WHERE o.ID = c.IDorFK AND o.ID = "+id+" AND b.ID = "+b.getId()+" AND b.ID = o.IDbarFK and o.Confermato = 0");
			listing = Ris.getResultList();
			listquan = Ris2.getResultList(); //lista di interi
			em.getTransaction().commit();
		}catch (Exception e){
            chk=-1;
             System.out.println("HibernateException Occured!!"+e);
            e.printStackTrace();
    }
	if(chk==0)
	{
		 if(listing.isEmpty() || listquan.isEmpty())
		 {
		        return (null);
		 }
		 else
		 {
			String concatena ="";
		    for(int i : listquan) {
		    	concatena += listing.get(i)+listquan.get(i);
		    }
	    	return concatena;
		 }
		}
		else
		{
		    return (null);
		}
	}
	
}