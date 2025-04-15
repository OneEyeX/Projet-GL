package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typelettre")
public class TypeLettre implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)	
	private Integer typeLettreId ;
	
	private String typeLettreLibelle ;
	private String typeLettreLibelleAr ;

	
	//constructor
	public TypeLettre(Integer typeLettreId, String typeLettreLibelle, String typeLettreLibelleAr) {
		super();
		this.typeLettreId = typeLettreId;
		this.typeLettreLibelle = typeLettreLibelle;
		this.typeLettreLibelleAr=typeLettreLibelleAr;
	}


	public TypeLettre() {
		super();
	}

	//getters&setters
	public Integer getTypeLettreId() {
		return typeLettreId;
	}

	public void setTypeLettreId(Integer typeLettreId) {
		this.typeLettreId = typeLettreId;
	}

	public String getTypeLettreLibelle() {
		return typeLettreLibelle;
	}

	public void setTypeLettreLibelle(String typeLettreLibelle) {
		this.typeLettreLibelle = typeLettreLibelle;
	}

	public String getTypeLettreLibelleAr() {
		return typeLettreLibelleAr;
	}

	public void setTypeLettreLibelleAr(String typeLettreLibelleAr) {
		this.typeLettreLibelleAr = typeLettreLibelleAr;
	}
	
	
	
	

}
