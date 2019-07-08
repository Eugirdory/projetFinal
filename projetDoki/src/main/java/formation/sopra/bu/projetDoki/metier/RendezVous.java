package formation.sopra.bu.projetDoki.metier;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

@Entity
@Table(name = "rendezVous")
public class RendezVous {

//Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqRendezVous")
	@SequenceGenerator(name = "seqRendezVous", sequenceName = "seq_rendezVous", initialValue = 100, allocationSize = 1)
	@Column(name = "id_rendezVous")
	private Integer id;
	
	@Column(name = "date_rendezVous")
	@Temporal(TemporalType.DATE)
	private Date dateRdv;
	@Column(name = "heure_rendezVous")
	@Temporal(TemporalType.TIME)
	private Date heureRdv;
	
	@ManyToOne
	Motif motif;
	@ManyToOne
	Patient patient;
	@ManyToOne
	Praticien praticien;
	
	@Version
	private int version;

//Constructeurs
	public RendezVous() {
		super();
	}

	public RendezVous(Date dateRdv, Date heureRdv, Motif motif, Patient patient, Praticien praticien, int version) {
		super();
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		this.motif = motif;
		this.patient = patient;
		this.praticien = praticien;
		this.version = version;
	}

	public RendezVous(Integer id, Date dateRdv, Date heureRdv, Motif motif, Patient patient, Praticien praticien,
			int version) {
		super();
		this.id = id;
		this.dateRdv = dateRdv;
		this.heureRdv = heureRdv;
		this.motif = motif;
		this.patient = patient;
		this.praticien = praticien;
		this.version = version;
	}

	//Getters & Setters
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateRdv() {
		return dateRdv;
	}

	public void setDateRdv(Date dateRdv) {
		this.dateRdv = dateRdv;
	}

	public Date getHeureRdv() {
		return heureRdv;
	}

	public void setHeureRdv(Date heureRdv) {
		this.heureRdv = heureRdv;
	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

//Hashcode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateRdv == null) ? 0 : dateRdv.hashCode());
		result = prime * result + ((heureRdv == null) ? 0 : heureRdv.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + version;
		return result;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RendezVous other = (RendezVous) obj;
		if (dateRdv == null) {
			if (other.dateRdv != null)
				return false;
		} else if (!dateRdv.equals(other.dateRdv))
			return false;
		if (heureRdv == null) {
			if (other.heureRdv != null)
				return false;
		} else if (!heureRdv.equals(other.heureRdv))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (version != other.version)
			return false;
		return true;
	}
}
