package formation.sopra.bu.projetDoki.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "join_praticien_motif")
public class PraticienMotif {
	
//Attributs
	@EmbeddedId
	private PraticienMotifKey key;

//Getters & Setters
	public PraticienMotifKey getKey() {
		return key;
	}

	public void setKey(PraticienMotif key) {
		this.key = key;
	}

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
		PraticienMotif other = (PraticienMotif) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
