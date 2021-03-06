package model;

import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

	private String nome;

	private String orarioApertura;

	private String orarioChiusura;

	private String password;

	private float valutazione;

	//bi-directional many-to-one association to Indirizzo
	@ManyToOne
	@JoinColumn(name="IDinFK")
	@JsonBackReference
	private Indirizzo indirizzo;

	//bi-directional many-to-one association to Classificato
	@OneToMany(mappedBy="bar")
	@JsonBackReference
	private List<Classificato> classificatos;

	//bi-directional many-to-one association to Menu
	@OneToMany(mappedBy="bar")
	@JsonBackReference
	private List<Menu> menus;

	//bi-directional many-to-one association to Ordine
	@OneToMany(mappedBy="bar")
	@JsonBackReference
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

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public List<Classificato> getClassificatos() {
		return this.classificatos;
	}

	public void setClassificatos(List<Classificato> classificatos) {
		this.classificatos = classificatos;
	}

	public Classificato addClassificato(Classificato classificato) {
		getClassificatos().add(classificato);
		classificato.setBar(this);

		return classificato;
	}

	public Classificato removeClassificato(Classificato classificato) {
		getClassificatos().remove(classificato);
		classificato.setBar(null);

		return classificato;
	}

	public List<Menu> getMenus() {
		return this.menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public Menu addMenus(Menu menus) {
		getMenus().add(menus);
		menus.setBar(this);

		return menus;
	}

	public Menu removeMenus(Menu menus) {
		getMenus().remove(menus);
		menus.setBar(null);

		return menus;
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