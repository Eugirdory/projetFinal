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


@Entity
@Table(name = "patient")
@DiscriminatorValue("patient")
public class Patient extends Personne {

	@Column(name = "date_naissance")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_patient")),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_patient", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_patient", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_patient", length = 150)),
			@AttributeOverride(name = "code", column = @Column(name = "code_patient", length = 150))})
	private Adresse domicile;
	@OneToMany (mappedBy = "patient")
	@Column(name = "rendez_vous_patient")
	private List <RendezVous> rdvs;
	
	public Patient() {
	}

	public Patient(Date dateNaissance, Adresse domicile, List<RendezVous> rdvs) {
		this.dateNaissance = dateNaissance;
		this.domicile = domicile;
		this.rdvs = rdvs;
	}

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
	
	
	
}
