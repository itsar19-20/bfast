package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the tipopagamento database table.
 * 
 */
@Entity
@NamedQuery(name="Tipopagamento.findAll", query="SELECT t FROM Tipopagamento t")
public class Tipopagamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String tipo;

	public Tipopagamento() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}