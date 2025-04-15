package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etatcategorie")
public class EtatCategorie implements Serializable {

	private static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer etatCategorieId ;
	private String etatCategorieLibelle ;
	private String etatCategorieDescription ;
	
	
	//constructor
	public EtatCategorie(Integer etatCategorieId, String etatCategorieLibelle, String etatCategorieDescription) {
		super();
		this.etatCategorieId = etatCategorieId;
		this.etatCategorieLibelle = etatCategorieLibelle;
		this.etatCategorieDescription = etatCategorieDescription;
	}

	public EtatCategorie() {
		super();
	}

	
	//getters&setters
	public Integer getEtatCategorieId() {
		return etatCategorieId;
	}

	public void setEtatCategorieId(Integer etatCategorieId) {
		this.etatCategorieId = etatCategorieId;
	}

	public String getEtatCategorieLibelle() {
		return etatCategorieLibelle;
	}

	public void setEtatCategorieLibelle(String etatCategorieLibelle) {
		this.etatCategorieLibelle = etatCategorieLibelle;
	}

	@Column(name="etatCategorieDescription",length = 1000)
	public String getEtatCategorieDescription() {
		return etatCategorieDescription;
	}

	public void setEtatCategorieDescription(String etatCategorieDescription) {
		this.etatCategorieDescription = etatCategorieDescription;
	}
	
	


}
