package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	private String nome;

	private String ingredienti;

	private float prezzo;

	private String tipo;

	//bi-directional many-to-one association to Contiene
	@OneToMany(mappedBy="prodotto")
	@JsonBackReference
	private List<Contiene> contienes;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="prodotto")
	@JsonBackReference
	private List<Menu> menus;

	
	
	@Override
	public String toString() {
		return "Prodotto [nome=" + nome + ", ingredienti=" + ingredienti + ", prezzo=" + prezzo + ", tipo=" + tipo
				+ "]";
	}

	public Prodotto() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setProdotto(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setProdotto(null);

		return menus;
	}

}