package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the risposta database table.
 * 
 */
@Entity
@NamedQuery(name="Risposta.findAll", query="SELECT r FROM Risposta r")
public class Risposta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String risposta;

	//bi-directional many-to-one association to Possiede
	@OneToMany(mappedBy="risposta")
	private List<Possiede> possiedes;

	public Risposta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRisposta() {
		return this.risposta;
	}

	public void setRisposta(String risposta) {
		this.risposta = risposta;
	}

	public List<Possiede> getPossiedes() {
		return this.possiedes;
	}

	public void setPossiedes(List<Possiede> possiedes) {
		this.possiedes = possiedes;
	}

	public Possiede addPossiede(Possiede possiede) {
		getPossiedes().add(possiede);
		possiede.setRisposta(this);

		return possiede;
	}

	public Possiede removePossiede(Possiede possiede) {
		getPossiedes().remove(possiede);
		possiede.setRisposta(null);

		return possiede;
	}

}