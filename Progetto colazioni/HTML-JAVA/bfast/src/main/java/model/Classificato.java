package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the classificato database table.
 * 
 */
@Entity
@NamedQuery(name="Classificato.findAll", query="SELECT c FROM Classificato c")
public class Classificato implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	//bi-directional many-to-one association to Bar
	@ManyToOne
	@JoinColumn(name="IDbaFK")
	private Bar bar;

	//bi-directional many-to-one association to Filtro
	@ManyToOne
	@JoinColumn(name="IDfiFK")
	private Filtro filtro;

	public Classificato() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Bar getBar() {
		return this.bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Filtro getFiltro() {
		return this.filtro;
	}

	public void setFiltro(Filtro filtro) {
		this.filtro = filtro;
	}

}