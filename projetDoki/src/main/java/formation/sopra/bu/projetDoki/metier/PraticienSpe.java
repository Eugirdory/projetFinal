package formation.sopra.bu.projetDoki.metier;

import javax.persistence.*;


@Entity
@Table(name = "join_praticien_specialite")
public class PraticienSpe {
	@EmbeddedId
	private PraticienSpeKey key;

	public PraticienSpeKey getKey() {
		return key;
	}

	public void setKey(PraticienSpeKey key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PraticienSpe other = (PraticienSpe) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	

}
