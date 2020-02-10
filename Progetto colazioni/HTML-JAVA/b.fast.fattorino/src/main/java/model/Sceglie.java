package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the sceglie database table.
 * 
 */
@Entity
@NamedQuery(name="Sceglie.findAll", query="SELECT s FROM Sceglie s")
public class Sceglie implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="IDutFK")
	private Utente utente;

	//bi-directional many-to-one association to Indirizzo
	@ManyToOne
	@JoinColumn(name="IDprFK")
	private Indirizzo indirizzo;

	public Sceglie() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

}