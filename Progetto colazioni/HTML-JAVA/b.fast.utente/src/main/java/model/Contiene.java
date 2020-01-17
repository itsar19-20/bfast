package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the contiene database table.
 * 
 */
@Entity
@NamedQuery(name="Contiene.findAll", query="SELECT c FROM Contiene c")
public class Contiene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne
	@JoinColumn(name="IDprFK")
	private Prodotto IDprFK;

	private int quantita;

	//bi-directional many-to-one association to Ordine
	@ManyToOne
	@JoinColumn(name="IDorFK")
	private Ordine ordine;

	public Contiene() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Prodotto getIDprFK() {
		return this.IDprFK;
	}

	public void setIDprFK(Prodotto IDprFK) {
		this.IDprFK = IDprFK;
	}

	public int getQuantita() {
		return this.quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public Ordine getOrdine() {
		return this.ordine;
	}

	public void setOrdine(Ordine ordine) {
		this.ordine = ordine;
	}

}