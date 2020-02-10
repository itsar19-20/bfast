package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte disponibilita;

	//bi-directional many-to-one association to Bar
	@ManyToOne
	@JoinColumn(name="IDbaFK")
	private Bar bar;

	//bi-directional many-to-one association to Prodotto
	@ManyToOne
	@JoinColumn(name="IDprFK")
	private Prodotto prodotto;

	public Menu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getDisponibilita() {
		return this.disponibilita;
	}

	public void setDisponibilita(byte disponibilita) {
		this.disponibilita = disponibilita;
	}

	public Bar getBar() {
		return this.bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Prodotto getProdotto() {
		return this.prodotto;
	}

	public void setProdotto(Prodotto prodotto) {
		this.prodotto = prodotto;
	}

}