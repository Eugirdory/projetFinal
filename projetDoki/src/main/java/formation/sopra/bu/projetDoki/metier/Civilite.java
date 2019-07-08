package formation.sopra.bu.projetDoki.metier;

public enum Civilite {

	M("Monsieur"), MME("Madame"), MLLE("Mademoiselle");
	private String civilite;

	private Civilite(String civilite) {
		this.civilite = civilite;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	
}
