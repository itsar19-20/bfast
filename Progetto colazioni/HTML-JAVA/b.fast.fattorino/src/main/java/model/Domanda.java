package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the domanda database table.
 * 
 */
@Entity
@NamedQuery(name="Domanda.findAll", query="SELECT d FROM Domanda d")
public class Domanda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String domanda;

	//bi-directional many-to-one association to Chiedef
	@OneToMany(mappedBy="domanda")
	private List<Chiedef> chiedefs;

	//bi-directional many-to-one association to Chiedeu
	@OneToMany(mappedBy="domanda")
	private List<Chiedeu> chiedeus;

	//bi-directional many-to-one association to Possiede
	@OneToMany(mappedBy="domanda")
	private List<Possiede> possiedes;

	public Domanda() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDomanda() {
		return this.domanda;
	}

	public void setDomanda(String domanda) {
		this.domanda = domanda;
	}

	public List<Chiedef> getChiedefs() {
		return this.chiedefs;
	}

	public void setChiedefs(List<Chiedef> chiedefs) {
		this.chiedefs = chiedefs;
	}

	public Chiedef addChiedef(Chiedef chiedef) {
		getChiedefs().add(chiedef);
		chiedef.setDomanda(this);

		return chiedef;
	}

	public Chiedef removeChiedef(Chiedef chiedef) {
		getChiedefs().remove(chiedef);
		chiedef.setDomanda(null);

		return chiedef;
	}

	public List<Chiedeu> getChiedeus() {
		return this.chiedeus;
	}

	public void setChiedeus(List<Chiedeu> chiedeus) {
		this.chiedeus = chiedeus;
	}

	public Chiedeu addChiedeus(Chiedeu chiedeus) {
		getChiedeus().add(chiedeus);
		chiedeus.setDomanda(this);

		return chiedeus;
	}

	public Chiedeu removeChiedeus(Chiedeu chiedeus) {
		getChiedeus().remove(chiedeus);
		chiedeus.setDomanda(null);

		return chiedeus;
	}

	public List<Possiede> getPossiedes() {
		return this.possiedes;
	}

	public void setPossiedes(List<Possiede> possiedes) {
		this.possiedes = possiedes;
	}

	public Possiede addPossiede(Possiede possiede) {
		getPossiedes().add(possiede);
		possiede.setDomanda(this);

		return possiede;
	}

	public Possiede removePossiede(Possiede possiede) {
		getPossiedes().remove(possiede);
		possiede.setDomanda(null);

		return possiede;
	}

}