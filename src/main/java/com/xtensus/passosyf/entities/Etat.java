package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="etat")
public class Etat implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer etatId ;
	
	private String etatLibelle ;
	private String etatLibelleAr ;
	private String etatImageCouleur ;
	private String etatOrdre ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etatCategorieId")
	private EtatCategorie etatCategorie;

	
	//constructor
	public Etat(Integer etatId, String etatLibelle, String etatLibelleAr, String etatImageCouleur, String etatOrdre,
			EtatCategorie etatCategorie) {
		super();
		this.etatId = etatId;
		this.etatLibelle = etatLibelle;
		this.etatLibelleAr = etatLibelleAr;
		this.etatImageCouleur = etatImageCouleur;
		this.etatOrdre = etatOrdre;
		this.etatCategorie = etatCategorie;
	}

	public Etat() {
		super();
		
	}

	//getters&setters
	public Integer getEtatId() {
		return etatId;
	}

	public void setEtatId(Integer etatId) {
		this.etatId = etatId;
	}

	public String getEtatLibelle() {
		return etatLibelle;
	}

	public void setEtatLibelle(String etatLibelle) {
		this.etatLibelle = etatLibelle;
	}

	public String getEtatLibelleAr() {
		return etatLibelleAr;
	}

	public void setEtatLibelleAr(String etatLibelleAr) {
		this.etatLibelleAr = etatLibelleAr;
	}

	public String getEtatImageCouleur() {
		return etatImageCouleur;
	}

	public void setEtatImageCouleur(String etatImageCouleur) {
		this.etatImageCouleur = etatImageCouleur;
	}

	public String getEtatOrdre() {
		return etatOrdre;
	}

	public void setEtatOrdre(String etatOrdre) {
		this.etatOrdre = etatOrdre;
	}
	
	public EtatCategorie getEtatCategorie() {
		return etatCategorie;
	}

	public void setEtatCategorie(EtatCategorie etatCategorie) {
		this.etatCategorie = etatCategorie;
	}
	
	

}
