package formation.sopra.bu.projetDoki.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
@Table(name = "motif")
public class Motif {
	
//Attributs
	@Id
	@SequenceGenerator(name = "seqMotif", sequenceName = "seq_motif", initialValue = 1, allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqMotif")
	@Column(name = "id_motif")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	
	@Column(name = "libelle")
	@JsonView(JsonViews.Common.class)
	private String libelle;
	@Column (name = "duree")
	@JsonView(JsonViews.Common.class)
	private Integer duree;
	
	@Version 
	private int version;
	
	@OneToMany(mappedBy = "key.motif")
	private List<PraticienMotif> motifs;
	
//Constructeur
	public Motif() {
		super();
	}

	public Motif(String libelle, Integer duree, int version) {
		super();
		this.libelle = libelle;
		this.duree = duree;
		this.version = version;
	}

	public Motif(Integer id, String libelle, Integer duree, int version) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.duree = duree;
		this.version = version;
	}

//Getters & Setters 
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

	public Integer getDuree() {
		return duree;
	}

	public void setDuree(Integer duree) {
		this.duree = duree;
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
		result = prime * result + ((duree == null) ? 0 : duree.hashCode());
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
		Motif other = (Motif) obj;
		if (duree == null) {
			if (other.duree != null)
				return false;
		} else if (!duree.equals(other.duree))
			return false;
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
