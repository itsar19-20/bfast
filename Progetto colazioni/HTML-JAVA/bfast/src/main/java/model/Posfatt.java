package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the posfatt database table.
 * 
 */
@Entity
@NamedQuery(name="Posfatt.findAll", query="SELECT p FROM Posfatt p")
public class Posfatt implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private double posXFA;

	private double posYFA;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="posfatt")
	private List<Ordine> ordines;

	public Posfatt() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPosXFA() {
		return this.posXFA;
	}

	public void setPosXFA(double posXFA) {
		this.posXFA = posXFA;
	}

	public double getPosYFA() {
		return this.posYFA;
	}

	public void setPosYFA(double posYFA) {
		this.posYFA = posYFA;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

	public Ordine addOrdine(Ordine ordine) {
		getOrdines().add(ordine);
		ordine.setPosfatt(this);

		return ordine;
	}

	public Ordine removeOrdine(Ordine ordine) {
		getOrdines().remove(ordine);
		ordine.setPosfatt(null);

		return ordine;
	}

}