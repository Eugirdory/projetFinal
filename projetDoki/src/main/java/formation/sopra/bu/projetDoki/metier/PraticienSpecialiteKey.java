package formation.sopra.bu.projetDoki.metier;

import java.io.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Embeddable
public class PraticienSpecialiteKey implements Serializable{
	
//Attributs
	@ManyToOne
	@JoinColumn(name = "praticien_id")
	private Praticien praticien;
	@ManyToOne
	@JoinColumn(name = "specialite_id")
	@JsonView(JsonViews.PraticienAvecSpe.class)
	private Specialite specialite;
	
//Constructeur
	public PraticienSpecialiteKey() {
	}
	public PraticienSpecialiteKey(Praticien praticien, Specialite specialite) {
		this.praticien = praticien;
		this.specialite = specialite;
	}
	
//Getter & Setter
	
	public Praticien getPraticien() {
		return praticien;
	}
	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}
	public Specialite getSpecialite() {
		return specialite;
	}
	public void setSpecialite(Specialite specialite) {
		this.specialite = specialite;
	}
	
//hashcode et equals
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((praticien == null) ? 0 : praticien.hashCode());
		result = prime * result + ((specialite == null) ? 0 : specialite.hashCode());
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
		PraticienSpecialiteKey other = (PraticienSpecialiteKey) obj;
		if (praticien == null) {
			if (other.praticien != null)
				return false;
		} else if (!praticien.equals(other.praticien))
			return false;
		if (specialite == null) {
			if (other.specialite != null)
				return false;
		} else if (!specialite.equals(other.specialite))
			return false;
		return true;
	}
	
}
