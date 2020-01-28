package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the indirizzo database table.
 * 
 */
@Entity
@NamedQuery(name="Indirizzo.findAll", query="SELECT i FROM Indirizzo i")
public class Indirizzo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String via;

	public Indirizzo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
	}

}