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

	private int cap;

	private String citta;

	private String civico;

	private String via;

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

	public int getCap() {
		return this.cap;
	}

	public void setCap(int cap) {
		this.cap = cap;
	}

	public String getCitta() {
		return this.citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCivico() {
		return this.civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public String getVia() {
		return this.via;
	}

	public void setVia(String via) {
		this.via = via;
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