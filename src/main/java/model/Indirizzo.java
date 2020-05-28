package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


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

	private double x;

	private double y;

	//bi-directional many-to-one association to Bar
	@OneToMany(mappedBy="indirizzo")
	private List<Bar> bars;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="indirizzo")
	private List<Ordine> ordines;

	//bi-directional many-to-one association to Sceglie
	@OneToMany(mappedBy="indirizzo")
	private List<Sceglie> sceglies;

	public Indirizzo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getX() {
		return this.x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return this.y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public List<Bar> getBars() {
		return this.bars;
	}

	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}

	public Bar addBar(Bar bar) {
		getBars().add(bar);
		bar.setIndirizzo(this);

		return bar;
	}

	public Bar removeBar(Bar bar) {
		getBars().remove(bar);
		bar.setIndirizzo(null);

		return bar;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

	public Ordine addOrdine(Ordine ordine) {
		getOrdines().add(ordine);
		ordine.setIndirizzo(this);

		return ordine;
	}

	public Ordine removeOrdine(Ordine ordine) {
		getOrdines().remove(ordine);
		ordine.setIndirizzo(null);

		return ordine;
	}

	public List<Sceglie> getSceglies() {
		return this.sceglies;
	}

	public void setSceglies(List<Sceglie> sceglies) {
		this.sceglies = sceglies;
	}

	public Sceglie addScegly(Sceglie scegly) {
		getSceglies().add(scegly);
		scegly.setIndirizzo(this);

		return scegly;
	}

	public Sceglie removeScegly(Sceglie scegly) {
		getSceglies().remove(scegly);
		scegly.setIndirizzo(null);

		return scegly;
	}

}