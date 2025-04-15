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
@Table(name="secteuractivite")
public class SecteurActivite implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer secteurActiviteId ;
	private String secteurActiviteLibelle ;
	private String secteurActiviteLibelleAr ;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etatId") 
	private Etat secteurActiviteEtat;
	
	private String secteurActiviteDescription ;
	private String secteurActiviteDescriptionAr ;
	
	
	//constructor
	public SecteurActivite(Integer secteurActiviteId, String secteurActiviteLibelle, String secteurActiviteLibelleAr,
			Etat secteurActiviteEtat, String secteurActiviteDescription, String secteurActiviteDescriptionAr) {
		super();
		this.secteurActiviteId = secteurActiviteId;
		this.secteurActiviteLibelle = secteurActiviteLibelle;
		this.secteurActiviteLibelleAr = secteurActiviteLibelleAr;
		this.secteurActiviteEtat = secteurActiviteEtat;
		this.secteurActiviteDescription = secteurActiviteDescription;
		this.secteurActiviteDescriptionAr = secteurActiviteDescriptionAr;
	}

	public SecteurActivite() {
		super();

	}

	//getters&setters
	public Integer getSecteurActiviteId() {
		return secteurActiviteId;
	}

	public void setSecteurActiviteId(Integer secteurActiviteId) {
		this.secteurActiviteId = secteurActiviteId;
	}

	@Column(name = "secteurActiviteLibelle", length = 255)
	public String getSecteurActiviteLibelle() {
		return secteurActiviteLibelle;
	}

	public void setSecteurActiviteLibelle(String secteurActiviteLibelle) {
		this.secteurActiviteLibelle = secteurActiviteLibelle;
	}

	@Column(name = "secteurActiviteLibelleAr", length = 255)
	public String getSecteurActiviteLibelleAr() {
		return secteurActiviteLibelleAr;
	}

	public void setSecteurActiviteLibelleAr(String secteurActiviteLibelleAr) {
		this.secteurActiviteLibelleAr = secteurActiviteLibelleAr;
	}

	public Etat getSecteurActiviteEtat() {
		return secteurActiviteEtat;
	}

	public void setSecteurActiviteEtat(Etat secteurActiviteEtat) {
		this.secteurActiviteEtat = secteurActiviteEtat;
	}

	@Column(name = "secteurActiviteDescription", length = 1000)
	public String getSecteurActiviteDescription() {
		return secteurActiviteDescription;
	}

	public void setSecteurActiviteDescription(String secteurActiviteDescription) {
		this.secteurActiviteDescription = secteurActiviteDescription;
	}

	@Column(name = "secteurActiviteDescriptionAr", length = 1000)
	public String getSecteurActiviteDescriptionAr() {
		return secteurActiviteDescriptionAr;
	}

	public void setSecteurActiviteDescriptionAr(String secteurActiviteDescriptionAr) {
		this.secteurActiviteDescriptionAr = secteurActiviteDescriptionAr;
	}
	
	
	
}
