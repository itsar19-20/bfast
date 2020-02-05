package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the fattorino database table.
 * 
 */
@Entity
@NamedQuery(name="Fattorino.findAll", query="SELECT f FROM Fattorino f")
public class Fattorino implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String cognome;

	private String mail;

	@Temporal(TemporalType.DATE)
	private Date nascità;

	private String nome;

	private String password;

	private float valutazione;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="fattorino")
	private List<Ordine> ordines;

	//bi-directional many-to-one association to Chiedef
	@OneToMany(mappedBy="fattorino")
	private List<Chiedef> chiedefs;

	public Fattorino() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCognome() {
		return this.cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Date getNascità() {
		return this.nascità;
	}

	public void setNascità(Date nascità) {
		this.nascità = nascità;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public float getValutazione() {
		return this.valutazione;
	}

	public void setValutazione(float valutazione) {
		this.valutazione = valutazione;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

	public Ordine addOrdine(Ordine ordine) {
		getOrdines().add(ordine);
		ordine.setFattorino(this);

		return ordine;
	}

	public Ordine removeOrdine(Ordine ordine) {
		getOrdines().remove(ordine);
		ordine.setFattorino(null);

		return ordine;
	}

	public List<Chiedef> getChiedefs() {
		return this.chiedefs;
	}

	public void setChiedefs(List<Chiedef> chiedefs) {
		this.chiedefs = chiedefs;
	}

	public Chiedef addChiedef(Chiedef chiedef) {
		getChiedefs().add(chiedef);
		chiedef.setFattorino(this);

		return chiedef;
	}

	public Chiedef removeChiedef(Chiedef chiedef) {
		getChiedefs().remove(chiedef);
		chiedef.setFattorino(null);

		return chiedef;
	}

}