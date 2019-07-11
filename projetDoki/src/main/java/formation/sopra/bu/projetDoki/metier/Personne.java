package formation.sopra.bu.projetDoki.metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Entity
@Table(name = "personnes")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PERSONNE", discriminatorType = DiscriminatorType.STRING)
public abstract class Personne {

//Attributs	
	@Id
	@Column(name = "username")
	@JsonView(JsonViews.Common.class)
	private String username;
	@Column(name = "nom")
	@JsonView(JsonViews.Common.class)
	private String nom;
	@Column(name = "prenom")
	@JsonView(JsonViews.Common.class)
	private String prenom;
	@Column(name = "mail")
	@JsonView(JsonViews.Common.class)
	private String mail;
	@Column(name = "telephone")
	@JsonView(JsonViews.Common.class)
	private String telephone;
	@Column(name = "civilite")
	@JsonView(JsonViews.Common.class)
	private String civilite;
	
	@Column(name = "password")
	private String password;
	private boolean enable;
	@OneToMany(mappedBy="personne",fetch = FetchType.LAZY)
	private List<UserRole> roles;
	@Version
	private int version;

//Constructeurs
	public Personne() {
	}
	
public Personne(String mail, String username, String password, String civilite, String nom, String prenom, String telephone, boolean enable, List<UserRole> roles, int version) {
	super();
	this.username = username;
	this.nom = nom;
	this.prenom = prenom;
	this.telephone = telephone;
	this.civilite = civilite;
	this.password = password;
	this.enable = enable;
	this.roles = roles;
	this.version = version;
}

//Getters & Setters	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}
	

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnable() {
		return enable;
	}

	public void setEnable(boolean enable) {
		this.enable = enable;
	}

	public List<UserRole> getRoles() {
		return roles;
	}

	public void setRoles(List<UserRole> roles) {
		this.roles = roles;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}


//HashCode & Equals
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		Personne other = (Personne) obj;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
		
}
