package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "typemarche")
public class TypeMarche implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "typeMarcheId", unique = true, nullable = false)
	private int typeMarcheId;
	
	private String typeMarcheLibelle;
	private String typeMarcheLibelleAr;
	private String typeMarcheAcronyme;
	private String typeMarcheDescription;
	private String typeMarcheDescriptionAr;
		
	//constructor	
	public TypeMarche(int typeMarcheId, String typeMarcheLibelle, String typeMarcheLibelleAr,
				String typeMarcheAcronyme, String typeMarcheDescription, String typeMarcheDescriptionAr) {
		this.typeMarcheId = typeMarcheId;
		this.typeMarcheLibelle = typeMarcheLibelle;
		this.typeMarcheLibelleAr = typeMarcheLibelleAr;
		this.typeMarcheAcronyme = typeMarcheAcronyme;
		this.typeMarcheDescription = typeMarcheDescription;
		this.typeMarcheDescriptionAr = typeMarcheDescriptionAr;
	}

	public TypeMarche() {
	}

	//getters&setters
	public int getTypeMarcheId() {
		
		return typeMarcheId;
	}

	public void setTypeMarcheId(int typeMarcheId) {
		this.typeMarcheId = typeMarcheId;
	}

	public String getTypeMarcheLibelle() {
		return typeMarcheLibelle;
	}

	public void setTypeMarcheLibelle(String typeMarcheLibelle) {
		this.typeMarcheLibelle = typeMarcheLibelle;
	}

	public String getTypeMarcheLibelleAr() {
		return typeMarcheLibelleAr;
	}

	public void setTypeMarcheLibelleAr(String typeMarcheLibelleAr) {
		this.typeMarcheLibelleAr = typeMarcheLibelleAr;
	}

	public String getTypeMarcheAcronyme() {
		return typeMarcheAcronyme;
	}

	public void setTypeMarcheAcronyme(String typeMarcheAcronyme) {
		this.typeMarcheAcronyme = typeMarcheAcronyme;
	}


	public String getTypeMarcheDescription() {
		return typeMarcheDescription;
	}

	public void setTypeMarcheDescription(String typeMarcheDescription) {
		this.typeMarcheDescription = typeMarcheDescription;
	}

	public String getTypeMarcheDescriptionAr() {
		return typeMarcheDescriptionAr;
	}

	public void setTypeMarcheDescriptionAr(String typeMarcheDescriptionAr) {
		this.typeMarcheDescriptionAr = typeMarcheDescriptionAr;
	}
		
		
		
		
		
		
		
		
}
