package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the appartiene database table.
 * 
 */
@Entity
@NamedQuery(name="Appartiene.findAll", query="SELECT a FROM Appartiene a")
public class Appartiene implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int IDprFK;

	//bi-directional many-to-one association to Menu
	@ManyToOne
	@JoinColumn(name="IDmeFK")
	private Menu menu;

	public Appartiene() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIDprFK() {
		return this.IDprFK;
	}

	public void setIDprFK(int IDprFK) {
		this.IDprFK = IDprFK;
	}

	public Menu getMenu() {
		return this.menu;
	}

	public void setMenu(Menu menu) {
		this.menu = menu;
	}

}