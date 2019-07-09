package formation.sopra.bu.projetDoki.metier;

public enum Civilite {

	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");

// Attribut
	private String civilite;

// Constructeur
	private Civilite(String civilite) {
		this.civilite = civilite;
	}

// Getter & Setter
	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

}
