package utils;

public class OrdiniUtil {
	
	private int id;
	
	private String ingredienti;
		
	private String note;

	private String orario;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(String ingredienti) {
		this.ingredienti = ingredienti;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getOrario() {
		return orario;
	}

	public void setOrario(String orario) {
		this.orario = orario;
	}

	@Override
	public String toString() {
		return "OrdiniUtil [id=" + id + ", ingredienti=" + ingredienti + ", note=" + note + ", orario=" + orario + "]";
	}
	
	

}
