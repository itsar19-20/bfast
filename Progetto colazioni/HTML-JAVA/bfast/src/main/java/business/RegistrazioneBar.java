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
			int id = 0;
			try {
				Query Ris = em.createNativeQuery("SELECT i.id FROM Indirizzo as i "
						+ "WHERE i.x = "+x+" AND i.y = "+y+"");
	        	id = Ris.getFirstResult();
				i= em.find(Indirizzo.class, id);
			}catch (Exception e)
	        {
	            chk=-1;
	             System.out.println("HibernateException Occured!!"+e);
	            e.printStackTrace();
		    }
			if(chk==0)
			{
			    return (i);
			}
			else
			{
				try {
					i = new Indirizzo(); 
					em.getTransaction().begin();
					i.setX(x);
					i.setY(y);
					em.getTransaction().commit();
				    return (i);
				}catch (NullPointerException e)
		        {
		            System.out.println("HibernateException Occured!!"+e);
		            e.printStackTrace();
		            return(null);
			    }
				
			}
			
			}	
}