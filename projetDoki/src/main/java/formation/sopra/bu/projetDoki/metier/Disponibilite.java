package formation.sopra.bu.projetDoki.metier;

import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
public class Disponibilite {
	
	@Id
	@GeneratedValue (strategy = GenerationType.SEQUENCE)
	@JsonView(JsonViews.Common.class)
	private Integer idDispo; 
	
	@Enumerated(EnumType.ORDINAL)
	@JsonView(JsonViews.Common.class)
	private Jour jour;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(JsonViews.Common.class)
	private Date heureDebut;
	
	@Temporal(TemporalType.TIMESTAMP)
	@JsonView(JsonViews.Common.class)
	private Date heureFin;
	
	@Embedded
	@JsonView(JsonViews.Common.class)
	private Adresse cabinet;
	
	public Disponibilite() {}

	public Disponibilite(Integer idDispo, Jour jour, Date heureDebut, Date heureFin, Adresse cabinet) {
		super();
		this.idDispo = idDispo;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.cabinet = cabinet;
	} 
	
	public Disponibilite(Jour jour, Date heureDebut, Date heureFin, Adresse cabinet) {
		super();
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.cabinet = cabinet;
	}

	public Integer getIdDispo() {
		return idDispo;
	}

	public void setIdDispo(Integer idDispo) {
		this.idDispo = idDispo;
	}

	public Jour getJour() {
		return jour;
	}

	public void setJour(Jour jour) {
		this.jour = jour;
	}

	public Date getHeureDebut() {
		return heureDebut;
	}

	public void setHeureDebut(Date heureDebut) {
		this.heureDebut = heureDebut;
	}

	public Date getHeureFin() {
		return heureFin;
	}

	public void setHeureFin(Date heureFin) {
		this.heureFin = heureFin;
	}

	public Adresse getCabinet() {
		return cabinet;
	}

	public void setCabinet(Adresse cabinet) {
		this.cabinet = cabinet;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idDispo == null) ? 0 : idDispo.hashCode());
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
		Disponibilite other = (Disponibilite) obj;
		if (idDispo == null) {
			if (other.idDispo != null)
				return false;
		} else if (!idDispo.equals(other.idDispo))
			return false;
		return true;
	} 
	
	

}
