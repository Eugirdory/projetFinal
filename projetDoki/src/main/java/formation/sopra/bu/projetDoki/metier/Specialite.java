package formation.sopra.bu.projetDoki.metier;

import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.*;

@Entity
@Table(name = "Specialite")
public class Specialite {

	@Id
	@SequenceGenerator(name = "seqSpecialite", sequenceName = "seq_specialite", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqSpecialite")
	@Column(name = "id_specialite")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@Column(name = "libelle")
	@JsonView(JsonViews.Common.class)
	private String libelle;

	@Version
	private int version;

	@OneToMany(mappedBy = "key.specialite")
	@JsonView(JsonViews.Common.class)
	private Set<PraticienSpecialite> praticiens;

//Constructeur

	public Specialite() {
	}

	public Specialite(String libelle) {
		this.libelle = libelle;
	}

	public Specialite(Integer id, String libelle) {
		this.id = id;
		this.libelle = libelle;
	}

//Getter et Setter
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<PraticienSpecialite> getPraticiens() {
		return praticiens;
	}

	public void setPraticiens(Set<PraticienSpecialite> praticiens) {
		this.praticiens = praticiens;
	}

// HashCode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		Specialite other = (Specialite) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		if (version != other.version)
			return false;
		return true;
	}

}