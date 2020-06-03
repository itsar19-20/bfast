package business;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import model.Bar;
import model.Menu;
import model.Prodotto;
import utils.JPAUtil;

public class GestioneMenu {
	
	public Menu Aggiungi(String nome,int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
		Menu m = new Menu();
		Bar b = em.find(Bar.class, id);
		Prodotto p = em.find(Prodotto.class, nome);
		m.setBar(b);
		m.setProdotto(p);
		m.setDisponibilita(1);
		try {
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
		}catch(Exception e) {
			m = null;
		}
		return m;
	}
	
	public Menu Rimuovi(String nome,int id) {
		EntityManager em = JPAUtil.getInstance().getEmf().createEntityManager();
	    List<Integer> idc = new ArrayList<Integer>();
	    Menu m = null;
	    int ris = 0;
	    try {
		    Query Ris = em.createNativeQuery("SELECT m.ID FROM menu as m,prodotto as p,bar as b "
		    		+ "WHERE b.id = "+id+" AND m.IDbaFK = b.id AND p.Nome =\""+nome+"\" AND m.IDprFK = p.Nome");
			idc = Ris.getResultList();
			int count = idc.size();
			for(int a=0;a<count;a++) {
				m = em.find(Menu.class, idc.get(a));
				em.getTransaction().begin();
				em.remove(m);
				em.getTransaction().commit();
			}
	    }catch(Exception e) {
	    	ris = 1;
	    }
	    
	    if(ris == 1) {
	       m = null;
	    }

	    return m;
	    
	}

}
