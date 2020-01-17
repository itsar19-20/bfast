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

	@Temporal(TemporalType.DATE)
	private Date data;

	private String note;

	@Temporal(TemporalType.DATE)
	private Date orario;

	private String tipoPagamento;

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

	public Ordine() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Date getOrario() {
		return this.orario;
	}

	public void setOrario(Date orario) {
		this.orario = orario;
	}

	public String getTipoPagamento() {
		return this.tipoPagamento;
	}

	public void setTipoPagamento(String tipoPagamento) {
		this.tipoPagamento = tipoPagamento;
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

}