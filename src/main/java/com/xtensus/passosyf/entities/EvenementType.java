package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeevenement")
public class EvenementType implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)	
	private Integer evenementTypeId ;
	
	private String evenementTypeLibelle ;
	private String evenementTypeLibelleAr ;
	private String evenementTypeDescription ;
	private String evenementTypeDescriptionAr ;
	private String evenementNomVariable ;
	private Boolean evenementSuppression ;
	
	//constructor
	public EvenementType(Integer evenementTypeId, String evenementTypeLibelle, String evenementTypeLibelleAr,
			String evenementTypeDescription, String evenementTypeDescriptionAr, String evenementNomVariable,
			Boolean evenementSuppression) {
		super();
		this.evenementTypeId = evenementTypeId;
		this.evenementTypeLibelle = evenementTypeLibelle;
		this.evenementTypeLibelleAr = evenementTypeLibelleAr;
		this.evenementTypeDescription = evenementTypeDescription;
		this.evenementTypeDescriptionAr = evenementTypeDescriptionAr;
		this.evenementNomVariable = evenementNomVariable;
		this.evenementSuppression = evenementSuppression;
	}


	public EvenementType() {
		super();

	}

	//getters&setters
	public Integer getEvenementTypeId() {
		return evenementTypeId;
	}

	public void setEvenementTypeId(Integer evenementTypeId) {
		this.evenementTypeId = evenementTypeId;
	}

	public String getEvenementTypeLibelle() {
		return evenementTypeLibelle;
	}

	public void setEvenementTypeLibelle(String evenementTypeLibelle) {
		this.evenementTypeLibelle = evenementTypeLibelle;
	}

	public String getEvenementTypeLibelleAr() {
		return evenementTypeLibelleAr;
	}

	public void setEvenementTypeLibelleAr(String evenementTypeLibelleAr) {
		this.evenementTypeLibelleAr = evenementTypeLibelleAr;
	}

	@Column(name = "evenementTypeDescription", length = 1000)
	public String getEvenementTypeDescription() {
		return evenementTypeDescription;
	}

	public void setEvenementTypeDescription(String evenementTypeDescription) {
		this.evenementTypeDescription = evenementTypeDescription;
	}
	
	@Column(name = "evenementTypeDescriptionAr", length = 1000)
	public String getEvenementTypeDescriptionAr() {
		return evenementTypeDescriptionAr;
	}

	public void setEvenementTypeDescriptionAr(String evenementTypeDescriptionAr) {
		this.evenementTypeDescriptionAr = evenementTypeDescriptionAr;
	}

	public String getEvenementNomVariable() {
		return evenementNomVariable;
	}

	public void setEvenementNomVariable(String evenementNomVariable) {
		this.evenementNomVariable = evenementNomVariable;
	}

	public Boolean getEvenementSuppression() {
		return evenementSuppression;
	}

	public void setEvenementSuppression(Boolean evenementSuppression) {
		this.evenementSuppression = evenementSuppression;
	}
	
	
}
