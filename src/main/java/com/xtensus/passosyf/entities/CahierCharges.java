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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="cahiercharges")
public class CahierCharges implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int cahierChargesId;
	
	private String cahierChargesLibelle;
	private String cahierChargesDescription;
	private float cahierChargesPrix;
	private Boolean cahierChargesPayant;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoriesProjetId")
	private CategoriesProjet categoriesProjet;
	
	@OneToOne
    @JoinColumn(name = "appelOffreId")
	@JsonIgnore
	AppelOffres appelOffre;

	
	//constructor
	public CahierCharges(int cahierChargesId, String cahierChargesLibelle, String cahierChargesDescription,
			float cahierChargesPrix, Boolean cahierChargesPayant, CategoriesProjet categoriesProjet,AppelOffres appelOffre) {
		super();
		this.cahierChargesId = cahierChargesId;
		this.cahierChargesLibelle = cahierChargesLibelle;
		this.cahierChargesDescription = cahierChargesDescription;
		this.cahierChargesPrix = cahierChargesPrix;
		this.cahierChargesPayant = cahierChargesPayant;
		this.categoriesProjet = categoriesProjet;
		this.appelOffre=appelOffre;
	}

	public CahierCharges() {
		super();

	}

	//getters&setters
	public int getCahierChargesId() {
		return cahierChargesId;
	}

	public void setCahierChargesId(int cahierChargesId) {
		this.cahierChargesId = cahierChargesId;
	}
	
	@Column(name = "cahierChargesLibelle", length = 100)
	public String getCahierChargesLibelle() {
		return cahierChargesLibelle;
	}

	public void setCahierChargesLibelle(String cahierChargesLibelle) {
		this.cahierChargesLibelle = cahierChargesLibelle;
	}
	
	@Column(name = "cahierChargesDescription", length = 1000)
	public String getCahierChargesDescription() {
		return cahierChargesDescription;
	}

	public void setCahierChargesDescription(String cahierChargesDescription) {
		this.cahierChargesDescription = cahierChargesDescription;
	}

	public float getCahierChargesPrix() {
		return cahierChargesPrix;
	}

	public void setCahierChargesPrix(float cahierChargesPrix) {
		this.cahierChargesPrix = cahierChargesPrix;
	}

	public Boolean getCahierChargesPayant() {
		return cahierChargesPayant;
	}

	public void setCahierChargesPayant(Boolean cahierChargesPayant) {
		this.cahierChargesPayant = cahierChargesPayant;
	}


	public CategoriesProjet getCategoriesProjet() {
		return categoriesProjet;
	}

	public void setCategoriesProjet(CategoriesProjet categoriesProjet) {
		this.categoriesProjet = categoriesProjet;
	}

	public AppelOffres getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffres appelOffre) {
		this.appelOffre = appelOffre;
	}
	
	
}
