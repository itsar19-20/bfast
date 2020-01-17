package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the prodotto database table.
 * 
 */
@Entity
@NamedQuery(name="Prodotto.findAll", query="SELECT p FROM Prodotto p")
public class Prodotto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String ingredienti;

	private float prezzo;

	private String tipo;

	//bi-directional many-to-one association to Appartiene
	@OneToMany(mappedBy="prodotto")
	private List<Appartiene> appartienes;

	//bi-directional many-to-one association to Contiene
	@OneToMany(mappedBy="prodotto")
	private List<Contiene> contienes;

	public Prodotto() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredienti() {
		return this.ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public float getPrezzo() {
		return this.prezzo;
	}

	public void setPrezzo(float prezzo) {
		this.prezzo = prezzo;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Appartiene> getAppartienes() {
		return this.appartienes;
	}

	public void setAppartienes(List<Appartiene> appartienes) {
		this.appartienes = appartienes;
	}

	public Appartiene addAppartiene(Appartiene appartiene) {
		getAppartienes().add(appartiene);
		appartiene.setProdotto(this);

		return appartiene;
	}

	public Appartiene removeAppartiene(Appartiene appartiene) {
		getAppartienes().remove(appartiene);
		appartiene.setProdotto(null);

		return appartiene;
	}

	public List<Contiene> getContienes() {
		return this.contienes;
	}

	public void setContienes(List<Contiene> contienes) {
		this.contienes = contienes;
	}

	public Contiene addContiene(Contiene contiene) {
		getContienes().add(contiene);
		contiene.setProdotto(this);

		return contiene;
	}

	public Contiene removeContiene(Contiene contiene) {
		getContienes().remove(contiene);
		contiene.setProdotto(null);

		return contiene;
	}

}