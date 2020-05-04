package business;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Indirizzo;
import utils.JPAUtil;

public class RegistrazioneBar {

	
	public Bar registrazione(String nome,String mail,String pass,String copass) throws ParseException
	{
		Bar _return = null;
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		if(!pass.equals(copass)) {
		}else {
			_return = registrazione(nome,mail,pass,copass,em);
		}
			
		return _return;
	}


	
	public Bar registrazione(String nome,String mail,String pass,String copass,EntityManager em) {
		Bar b= new Bar();
		b.setEmail(mail);
		b.setNome(nome);
		b.setPassword(pass);
		em.getTransaction().begin();
	    em.persist(b);
	    em.getTransaction().commit();
	    return b;
	}



	public Bar Conregistrazione(int s, String orarioap, String orarioch, String  x1, String  y1) {
		Bar _return = null;
		Indirizzo i = null;
		double x = Double.parseDouble(x1);
		double y = Double.parseDouble(y1);
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		_return = em.find(Bar.class, s);
		if (_return != null) {
			_return.setOrarioApertura(orarioap);
			_return.setOrarioChiusura(orarioch);
			i = cerca(x,y,em);		
			_return.setIndirizzo(i);
			em.getTransaction().begin();
		    em.persist(_return);
		    em.getTransaction().commit();
		}
		return _return;
	}
	
	public Indirizzo cerca(double x, double y,EntityManager em) {
        int chk=0;
		Indirizzo i = null;
		try {
			em.getTransaction().begin();
			Query Ris = em.createQuery("SELECT i.id FROM Indirizzo as i "
					+ "WHERE i.x =:x AND i.y = :y"
					+ "").setParameter("x", x).setParameter("y", y);
			i = (Indirizzo) Ris.getSingleResult();
			em.getTransaction().commit();
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
		    return (i);
		}
		else
		{
		    return (new Indirizzo());
		}
		
		}		
}