package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the menu database table.
 * 
 */
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT m FROM Menu m")
public class Menu implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private int disponibilità;

	//bi-directional many-to-one association to Appartiene
	@OneToMany(mappedBy="menu")
	private List<Appartiene> appartienes;

	//bi-directional many-to-one association to Bar
	@OneToMany(mappedBy="menu")
	private List<Bar> bars;

	public Menu() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDisponibilità() {
		return this.disponibilità;
	}

	public void setDisponibilità(int disponibilità) {
		this.disponibilità = disponibilità;
	}

	public List<Appartiene> getAppartienes() {
		return this.appartienes;
	}

	public void setAppartienes(List<Appartiene> appartienes) {
		this.appartienes = appartienes;
	}

	public Appartiene addAppartiene(Appartiene appartiene) {
		getAppartienes().add(appartiene);
		appartiene.setMenu(this);

		return appartiene;
	}

	public Appartiene removeAppartiene(Appartiene appartiene) {
		getAppartienes().remove(appartiene);
		appartiene.setMenu(null);

		return appartiene;
	}

	public List<Bar> getBars() {
		return this.bars;
	}

	public void setBars(List<Bar> bars) {
		this.bars = bars;
	}

	public Bar addBar(Bar bar) {
		getBars().add(bar);
		bar.setMenu(this);

		return bar;
	}

	public Bar removeBar(Bar bar) {
		getBars().remove(bar);
		bar.setMenu(null);

		return bar;
	}

}