package formation.sopra.bu.projetDoki.metier;

import java.util.Date;
import java.util.List;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
@Table(name = "patient")
@DiscriminatorValue("patient")
public class Patient extends Personne {

	@Column(name = "date_naissance")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@JsonView(JsonViews.Common.class)
	private Date dateNaissance;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_patient")),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_patient", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_patient", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_patient", length = 150))})

	@JsonView(JsonViews.Common.class)
	private Adresse domicile;
	@OneToMany(mappedBy = "patient")
	@Column(name = "rendez_vous_avec_patient")
	@JsonView(JsonViews.PatientAvecRdv.class)
	private List<RendezVous> rdvs;

//Constructeurs
	public Patient() {
	}

public Patient(String mail, String username, String password, String civilite, String nom, String prenom,
		String telephone, Adresse domicile, Date dateNaissance, List<RendezVous> rdvs, boolean enable, List<UserRole> roles, int version
		) {
	super(mail, username, password, civilite, nom, prenom, telephone, enable, roles, version);
	this.dateNaissance = dateNaissance;
	this.domicile = domicile;
	this.rdvs = rdvs;
}

//Getters & Setters 
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Adresse getDomicile() {
		return domicile;
	}

	public void setDomicile(Adresse domicile) {
		this.domicile = domicile;
	}

	public List<RendezVous> getRdvs() {
		return rdvs;
	}

	public void setRdvs(List<RendezVous> rdvs) {
		this.rdvs = rdvs;
	}

// HashCode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((domicile == null) ? 0 : domicile.hashCode());
		result = prime * result + ((rdvs == null) ? 0 : rdvs.hashCode());
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Patient other = (Patient) obj;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (domicile == null) {
			if (other.domicile != null)
				return false;
		} else if (!domicile.equals(other.domicile))
			return false;
		if (rdvs == null) {
			if (other.rdvs != null)
				return false;
		} else if (!rdvs.equals(other.rdvs))
			return false;
		return true;
	}

}
