package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ordine database table.
 * 
 */
@Entity
@NamedQuery(name="Ordine.findAll", query="SELECT o FROM Ordine o")
public class Ordine implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private byte confermato;

	@Temporal(TemporalType.DATE)
	private Date data;

	private String note;

	private String orario;

	private float valutazioneFatt;

	//bi-directional many-to-one association to Contiene
	@OneToMany(mappedBy="ordine")
	private List<Contiene> contienes;

	//bi-directional many-to-one association to Bar
	@ManyToOne
	@JoinColumn(name="IDbarFK")
	private Bar bar;

	//bi-directional many-to-one association to Fattorino
	@ManyToOne
	@JoinColumn(name="IDfatFK")
	private Fattorino fattorino;

	//bi-directional many-to-one association to Utente
	@ManyToOne
	@JoinColumn(name="IDutFK")
	private Utente utente;

	//bi-directional many-to-one association to Indirizzo
	@ManyToOne
	@JoinColumn(name="IDinFK")
	private Indirizzo indirizzo;

	//bi-directional many-to-one association to Posfatt
	@ManyToOne
	@JoinColumn(name="IDpoFK")
	private Posfatt posfatt;

	//bi-directional many-to-one association to Tipopagamento
	@ManyToOne
	@JoinColumn(name="IDtiFK")
	private Tipopagamento tipopagamento;

	public Ordine() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public byte getConfermato() {
		return this.confermato;
	}

	public void setConfermato(byte confermato) {
		this.confermato = confermato;
	}

	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrario() {
		return this.orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	public float getValutazioneFatt() {
		return this.valutazioneFatt;
	}

	public void setValutazioneFatt(float valutazioneFatt) {
		this.valutazioneFatt = valutazioneFatt;
	}

	public List<Contiene> getContienes() {
		return this.contienes;
	}

	public void setContienes(List<Contiene> contienes) {
		this.contienes = contienes;
	}

	public Contiene addContiene(Contiene contiene) {
		getContienes().add(contiene);
		contiene.setOrdine(this);

		return contiene;
	}

	public Contiene removeContiene(Contiene contiene) {
		getContienes().remove(contiene);
		contiene.setOrdine(null);

		return contiene;
	}

	public Bar getBar() {
		return this.bar;
	}

	public void setBar(Bar bar) {
		this.bar = bar;
	}

	public Fattorino getFattorino() {
		return this.fattorino;
	}

	public void setFattorino(Fattorino fattorino) {
		this.fattorino = fattorino;
	}

	public Utente getUtente() {
		return this.utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public Indirizzo getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(Indirizzo indirizzo) {
		this.indirizzo = indirizzo;
	}

	public Posfatt getPosfatt() {
		return this.posfatt;
	}

	public void setPosfatt(Posfatt posfatt) {
		this.posfatt = posfatt;
	}

	public Tipopagamento getTipopagamento() {
		return this.tipopagamento;
	}

	public void setTipopagamento(Tipopagamento tipopagamento) {
		this.tipopagamento = tipopagamento;
	}

}