package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the possiede database table.
 * 
 */
@Entity
@NamedQuery(name="Possiede.findAll", query="SELECT p FROM Possiede p")
public class Possiede implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Domanda
	@ManyToOne
	@JoinColumn(name="IDdoFK")
	private Domanda domanda;

	//bi-directional many-to-one association to Risposta
	@ManyToOne
	@JoinColumn(name="IDriFK")
	private Risposta risposta;

	public Possiede() {
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

	public Risposta getRisposta() {
		return this.risposta;
	}

	public void setRisposta(Risposta risposta) {
		this.risposta = risposta;
	}

}