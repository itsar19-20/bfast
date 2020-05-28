package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the chiedef database table.
 * 
 */
@Entity
@NamedQuery(name="Chiedef.findAll", query="SELECT c FROM Chiedef c")
public class Chiedef implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Domanda
	@ManyToOne
	@JoinColumn(name="IDdoFK")
	private Domanda domanda;

	//bi-directional many-to-one association to Fattorino
	@ManyToOne
	@JoinColumn(name="IDfatFK")
	private Fattorino fattorino;

	public Chiedef() {
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

	public Fattorino getFattorino() {
		return this.fattorino;
	}

	public void setFattorino(Fattorino fattorino) {
		this.fattorino = fattorino;
	}

}