package formation.sopra.bu.projetDoki.metier;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
public class Disponibilite {

//Attributs
	@Id
	@SequenceGenerator(name = "seqDispo", sequenceName = "seq_dispo", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@JsonView(JsonViews.Common.class)
	@Column(name = "id_dispo")
	private Integer id;

	@Enumerated(EnumType.STRING)
	@JsonView(JsonViews.Common.class)
	@Column(name = "jour")
	private Jour jour;

	@Temporal(TemporalType.TIME)
	@JsonView(JsonViews.Common.class)
	private Date heureDebut;

	@Temporal(TemporalType.TIME)
	@JsonView(JsonViews.Common.class)
	private Date heureFin;

	@Embedded
	@JsonView(JsonViews.Common.class)
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_rue_cabinet")),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_cabinet", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_cabinet", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_cabinet", length = 150)),
			@AttributeOverride(name = "code", column = @Column(name = "code_cabinet")) })
	private Adresse cabinet;

//Constructeur
	public Disponibilite() {
	}

	public Disponibilite(Integer idDispo, Jour jour, Date heureDebut, Date heureFin, Adresse cabinet) {
		super();
		this.id = id;
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.cabinet = cabinet;
	}

	public Disponibilite(Jour jour, Date heureDebut, Date heureFin, Adresse cabinet) {
		this.jour = jour;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.cabinet = cabinet;
	}

// Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

// HashCode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Disponibilite other = (Disponibilite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
