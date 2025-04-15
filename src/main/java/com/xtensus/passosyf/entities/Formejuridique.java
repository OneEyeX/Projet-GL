package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


//@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Entity
@Table(name="formejuridique")
public class Formejuridique implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer formeJuridiqueId ;
	
	private String formeJuridiqueNom ;
	
    //	private Set<Soumissionnaire> soumissionnaires = new HashSet<Soumissionnaire>(
    //	0);
	
	
	//constructor
	public Formejuridique(Integer formeJuridiqueId, String formeJuridiqueNom) {
		super();
		this.formeJuridiqueId = formeJuridiqueId;
		this.formeJuridiqueNom = formeJuridiqueNom;
	}

	public Formejuridique() {
		super();

	}

	//getters&setters
	public Integer getFormeJuridiqueId() {
		return formeJuridiqueId;
	}

	public void setFormeJuridiqueId(Integer formeJuridiqueId) {
		this.formeJuridiqueId = formeJuridiqueId;
	}

	public String getFormeJuridiqueNom() {
		return formeJuridiqueNom;
	}

	public void setFormeJuridiqueNom(String formeJuridiqueNom) {
		this.formeJuridiqueNom = formeJuridiqueNom;
	}
	
	
	//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "formejuridique")
	//	public Set<Soumissionnaire> getSoummissionnaires() {
	//		return this.soumissionnaires;
	//	}
	//
	//	public void setSoummissionnaires(Set<Soumissionnaire> soumissionnaires) {
	//		this.soumissionnaires = soumissionnaires;
	//	}
	
	
}
