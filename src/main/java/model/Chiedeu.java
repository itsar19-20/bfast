package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chiedeu database table.
 * 
 */
@Entity
@NamedQuery(name="Chiedeu.findAll", query="SELECT c FROM Chiedeu c")
public class Chiedeu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Domanda
	@ManyToOne
	@JoinColumn(name="IDdoFK")
	private Domanda domanda;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="IDutFK")
	private Utente utente;

	public Chiedeu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Domanda getDomanda() {
		return this.domanda;
	}

	public void setDomanda(Domanda domanda) {
		this.domanda = domanda;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

}