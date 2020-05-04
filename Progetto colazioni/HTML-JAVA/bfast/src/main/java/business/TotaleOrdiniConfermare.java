package business;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import java.util.ArrayList;
import java.util.List;

import model.Bar;
import model.Ordine;
import utils.JPAUtil;

public class TotaleOrdiniConfermare {
	
	public int  Visualizza(int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
        int chk=0;
        int numero = 0;
		Bar b = em.find(Bar.class, id);
		try {
			Query Ris = em.createQuery("SELECT COUNT(*) as conteggio FROM ordini as o, bar as b\r\n" + 
					"WHERE DAY(o.data) = DAY(getdate()) and ?b.id = o.IDbarFK and o.Confermato = '0' ").setParameter(1, b.getId());
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

	
	public List<Ordine> PagVisualizza(int id){
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Bar b = em.find(Bar.class, id);
		List<Ordine> lista = new ArrayList<Ordine> ();
		int chk = 0;
		try {
			em.getTransaction().begin();
			Query Ris = em.createQuery("SELECT COUNT(*) as conteggio FROM ordini as o, bar as b\r\n" + 
					"WHERE DAY(o.data) = DAY(getdate()) and :b.id = o.IDbarFK and o.Confermato = '0' ").setParameter("b.id", b.getId());
			lista = Ris.getResultList(); 
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
         return (lista);
    }
}
else
{
    return (null);
}

	}

}


