package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipopagamento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipopagamento.findAll", query="SELECT t FROM Tipopagamento t")
public class Tipopagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipo;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="tipopagamento")
	private List<Ordine> ordines;

	public Tipopagamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

	public Ordine addOrdine(Ordine ordine) {
		getOrdines().add(ordine);
		ordine.setTipopagamento(this);

		return ordine;
	}

	public Ordine removeOrdine(Ordine ordine) {
		getOrdines().remove(ordine);
		ordine.setTipopagamento(null);

		return ordine;
	}

}