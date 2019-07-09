package formation.sopra.bu.projetDoki.metier;

public enum Jour {
	LUNDI("Lundi"), MARDI("Mardi"), MERCREDI("Mercredi"), JEUDI("Jeudi"), VENDREDI("Vendredi"), SAMEDI("Samedi"),
	DIMANCHE("Dimanche");

//Attribut
	private String jour;

//Constructeur
	private Jour(String jour) {
		this.jour = jour;
	}

// Getter & Setter
	public String getJour() {
		return jour;
	}

	public void setJour(String jour) {
		this.jour = jour;
	}
}
