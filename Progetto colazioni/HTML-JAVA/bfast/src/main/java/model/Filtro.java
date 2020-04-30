package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the filtro database table.
 * 
 */
@Entity
@NamedQuery(name="Filtro.findAll", query="SELECT f FROM Filtro f")
public class Filtro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipo;

	//bi-directional many-to-one association to Classificato
	@OneToMany(mappedBy="filtro")
	private List<Classificato> classificatos;

	public Filtro() {
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

	public List<Classificato> getClassificatos() {
		return this.classificatos;
	}

	public void setClassificatos(List<Classificato> classificatos) {
		this.classificatos = classificatos;
	}

	public Classificato addClassificato(Classificato classificato) {
		getClassificatos().add(classificato);
		classificato.setFiltro(this);

		return classificato;
	}

	public Classificato removeClassificato(Classificato classificato) {
		getClassificatos().remove(classificato);
		classificato.setFiltro(null);

		return classificato;
	}

}