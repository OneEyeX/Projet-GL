package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="evenement")
public class Evenement implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)	
	private Integer evenementId ;
	
	private String evenementLibelle ;
	private String evenementLibelleAr ;
	private String evenementDescription ;
	private String evenementDescriptionAr ;
	private String evenementNomVariable ;
	private Boolean evenementSuppression ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "evenementTypeId")
	private EvenementType typeEvenement ;

	//constructor
	public Evenement(Integer evenementId, String evenementLibelle, String evenementLibelleAr,
			String evenementDescription, String evenementDescriptionAr, String evenementNomVariable,
			Boolean evenementSuppression, EvenementType typeEvenement) {
		super();
		this.evenementId = evenementId;
		this.evenementLibelle = evenementLibelle;
		this.evenementLibelleAr = evenementLibelleAr;
		this.evenementDescription = evenementDescription;
		this.evenementDescriptionAr = evenementDescriptionAr;
		this.evenementNomVariable = evenementNomVariable;
		this.evenementSuppression = evenementSuppression;
		this.typeEvenement = typeEvenement;
	}

	public Evenement() {
		super();

	}

	//getters&setters
	public Integer getEvenementId() {
		return evenementId;
	}

	public void setEvenementId(Integer evenementId) {
		this.evenementId = evenementId;
	}

	public String getEvenementLibelle() {
		return evenementLibelle;
	}

	public void setEvenementLibelle(String evenementLibelle) {
		this.evenementLibelle = evenementLibelle;
	}
	

	public String getEvenementLibelleAr() {
		return evenementLibelleAr;
	}

	public void setEvenementLibelleAr(String evenementLibelleAr) {
		this.evenementLibelleAr = evenementLibelleAr;
	}

	@Column(name = "evenementDescription", length = 1000)
	public String getEvenementDescription() {
		return evenementDescription;
	}

	public void setEvenementDescription(String evenementDescription) {
		this.evenementDescription = evenementDescription;
	}

	@Column(name = "evenementDescriptionAr", length = 1000)
	public String getEvenementDescriptionAr() {
		return evenementDescriptionAr;
	}

	public void setEvenementDescriptionAr(String evenementDescriptionAr) {
		this.evenementDescriptionAr = evenementDescriptionAr;
	}

	@Column(name = "evenementNomVariable", length = 100)
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

	public EvenementType getTypeEvenement() {
		return typeEvenement;
	}

	public void setTypeEvenement(EvenementType typeEvenement) {
		this.typeEvenement = typeEvenement;
	}

	
}
