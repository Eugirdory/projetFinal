package formation.sopra.bu.projetDoki.metier;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.bu.projetDoki.view.JsonViews;

@Embeddable
public class Adresse {
	@Column(name = "numero")
	@JsonView(JsonViews.Common.class)
	private Integer numero;
	
	@Column (name = "rue")
	@JsonView(JsonViews.Common.class)
	private String rue;
	
	@Column (name = "codePostal")
	@JsonView(JsonViews.Common.class)
	private String cp;
	
	@Column (name = "ville")
	@JsonView(JsonViews.Common.class)
	private String ville;
	
	@Column (name ="code")
	@JsonView(JsonViews.Common.class)
	private String code; 
	
	
	public Adresse() {}


	public Adresse(Integer numero, String rue, String cp, String ville, String code) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
		this.code = code;
	}
	

	public Integer getNumero() {
		return numero;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCp() {
		return cp;
	}


	public void setCp(String cp) {
		this.cp = cp;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}
	
	
}
