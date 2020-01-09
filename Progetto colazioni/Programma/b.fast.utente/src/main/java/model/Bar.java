package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the bar database table.
 * 
 */
@Entity
@NamedQuery(name="Bar.findAll", query="SELECT b FROM Bar b")
public class Bar implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String email;

	private float fascia;

	@Lob
	private byte[] immagine;

	private String indirizzo;

	private String nome;


	private String orarioApertura;

	private String orarioChiusura;

	private String password;

	private float valutazione;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="IDmeFK")
	private Menu menu;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="bar")
	private List<Ordine> ordines;

	public Bar() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public float getFascia() {
		return this.fascia;
	}

	public void setFascia(float fascia) {
		this.fascia = fascia;
	}

	public byte[] getImmagine() {
		return this.immagine;
	}

	public void setImmagine(byte[] immagine) {
		this.immagine = immagine;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getOrarioApertura() {
		return this.orarioApertura;
	}

	public void setOrarioApertura(String orarioApertura) {
		this.orarioApertura = orarioApertura;
	}

	public String getOrarioChiusura() {
		return this.orarioChiusura;
	}

	public void setOrarioChiusura(String orarioChiusura) {
		this.orarioChiusura = orarioChiusura;
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

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

	public List<Ordine> getOrdines() {
		return this.ordines;
	}

	public void setOrdines(List<Ordine> ordines) {
		this.ordines = ordines;
	}

	public Ordine addOrdine(Ordine ordine) {
		getOrdines().add(ordine);
		ordine.setBar(this);

		return ordine;
	}

	public Ordine removeOrdine(Ordine ordine) {
		getOrdines().remove(ordine);
		ordine.setBar(null);

		return ordine;
	}

}