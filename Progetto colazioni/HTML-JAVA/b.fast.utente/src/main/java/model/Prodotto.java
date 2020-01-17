package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the prodotto database table.
 * 
 */
@Entity
@NamedQuery(name="Prodotto.findAll", query="SELECT p FROM Prodotto p")
public class Prodotto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String Nome;

	private String ingredienti;

	private float prezzo;

	private String tipo;

	public Prodotto() {
	}

	public String getNome() {
		return this.ingredienti;
	}

	public void setNome(String nome) {
		this.Nome = nome;
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

}