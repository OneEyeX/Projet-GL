package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typepv")
public class TypePV implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer typePVId ;
	
	private String typePVLibelle ;
	private String typePVLibelleAr ;
	private String typePVDescription ;
	private String typePVDescriptionAr ;
	private String categorie ;	
	
	
	//constructor
	public TypePV(Integer typePVId, String typePVLibelle, String typePVLibelleAr, String typePVDescription,
			String typePVDescriptionAr, String categorie) {
		super();
		this.typePVId = typePVId;
		this.typePVLibelle = typePVLibelle;
		this.typePVLibelleAr = typePVLibelleAr;
		this.typePVDescription = typePVDescription;
		this.typePVDescriptionAr = typePVDescriptionAr;
		this.categorie = categorie;
	}


	public TypePV() {
		super();

	}

	//getters&setters
	public Integer getTypePVId() {
		return typePVId;
	}

	public void setTypePVId(Integer typePVId) {
		this.typePVId = typePVId;
	}

	@Column(name = "typePVLibelle", length = 255)
	public String getTypePVLibelle() {
		return typePVLibelle;
	}

	public void setTypePVLibelle(String typePVLibelle) {
		this.typePVLibelle = typePVLibelle;
	}

	@Column(name = "typePVLibelleAr", length = 255)
	public String getTypePVLibelleAr() {
		return typePVLibelleAr;
	}

	public void setTypePVLibelleAr(String typePVLibelleAr) {
		this.typePVLibelleAr = typePVLibelleAr;
	}

	@Column(name = "typePVDescription", length = 1000)
	public String getTypePVDescription() {
		return typePVDescription;
	}

	public void setTypePVDescription(String typePVDescription) {
		this.typePVDescription = typePVDescription;
	}

	@Column(name = "typePVDescriptionAr", length = 1000)
	public String getTypePVDescriptionAr() {
		return typePVDescriptionAr;
	}

	public void setTypePVDescriptionAr(String typePVDescriptionAr) {
		this.typePVDescriptionAr = typePVDescriptionAr;
	}

	@Column(name = "categorie", length = 254)
	public String getCategorie() {
		return categorie;
	}

	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	

	
	
}
