package formation.sopra.bu.projetDoki.metier;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class PraticienMotifKey implements Serializable {

//Attributs
	@ManyToOne
	@JoinColumn(name = "join_praticien_id")
	private Praticien praticien;
	@ManyToOne
	@JoinColumn(name = "join_motif_id")
	private Motif motif;

	
//Constructeurs
	public PraticienMotifKey() {

	}

	public PraticienMotifKey(Praticien praticien, Motif Motif) {
		super();
		this.praticien = praticien;
		this.motif = motif;
	}

//Getters & Setters
	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

//HashCode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((motif == null) ? 0 : motif.hashCode());
		result = prime * result + ((praticien == null) ? 0 : praticien.hashCode());
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
		PraticienMotifKey other = (PraticienMotifKey) obj;
		if (motif == null) {
			if (other.motif != null)
				return false;
		} else if (!motif.equals(other.motif))
			return false;
		if (praticien == null) {
			if (other.praticien != null)
				return false;
		} else if (!praticien.equals(other.praticien))
			return false;
		return true;
	}

}
