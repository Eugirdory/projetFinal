package formation.sopra.bu.projetDoki.metier;

import javax.persistence.*;


@Entity
@Table(name = "praticien_specialite")
public class PraticienSpecialite {
	
//Attributs
	@EmbeddedId
	private PraticienSpecialiteKey key;
	
//Constructeurs
	public PraticienSpecialite() {
	
	}
	
	public PraticienSpecialite(PraticienSpecialiteKey key) {
		this.key = key;
	}

//Getter & Setter
	public PraticienSpecialiteKey getKey() {
		return key;
	}

	public void setKey(PraticienSpecialiteKey key) {
		this.key = key;
	}

//Hashcode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PraticienSpecialite other = (PraticienSpecialite) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	

}
