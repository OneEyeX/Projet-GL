package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fonction")
public class Fonction implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)	
	private Integer fonctionId ;
	
	private String fonctionLibelle ;
	private String fonctionLibelleAr ;
	private String fonctionDescription ;
	private String fonctionDescriptionAr ;
	
	//constructor
	public Fonction(Integer fonctionId, String fonctionLibelle, String fonctionLibelleAr, String fonctionDescription,
			String fonctionDescriptionAr) {
		super();
		this.fonctionId = fonctionId;
		this.fonctionLibelle = fonctionLibelle;
		this.fonctionLibelleAr = fonctionLibelleAr;
		this.fonctionDescription = fonctionDescription;
		this.fonctionDescriptionAr = fonctionDescriptionAr;
	}

	public Fonction() {
		super();

	}

	//getters&setters
	public Integer getFonctionId() {
		return fonctionId;
	}

	public void setFonctionId(Integer fonctionId) {
		this.fonctionId = fonctionId;
	}

	public String getFonctionLibelle() {
		return fonctionLibelle;
	}

	public void setFonctionLibelle(String fonctionLibelle) {
		this.fonctionLibelle = fonctionLibelle;
	}

	public String getFonctionLibelleAr() {
		return fonctionLibelleAr;
	}

	public void setFonctionLibelleAr(String fonctionLibelleAr) {
		this.fonctionLibelleAr = fonctionLibelleAr;
	}

	public String getFonctionDescription() {
		return fonctionDescription;
	}

	public void setFonctionDescription(String fonctionDescription) {
		this.fonctionDescription = fonctionDescription;
	}

	public String getFonctionDescriptionAr() {
		return fonctionDescriptionAr;
	}

	public void setFonctionDescriptionAr(String fonctionDescriptionAr) {
		this.fonctionDescriptionAr = fonctionDescriptionAr;
	}
	
	

}
