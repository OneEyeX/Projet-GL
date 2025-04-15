package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="motif")
public class Motif implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer motifId ;
	
	private String motifLibelle ;
	private String motifLibelleAr ;
	private String motifCategorie ;
	private String motifDescription ;
	private String motifDescriptionAr ;
	
	//Constructor
	public Motif(Integer motifId, String motifLibelle, String motifLibelleAr, String motifCategorie,
			String motifDescription, String motifDescriptionAr) {
		super();
		this.motifId = motifId;
		this.motifLibelle = motifLibelle;
		this.motifLibelleAr = motifLibelleAr;
		this.motifCategorie = motifCategorie;
		this.motifDescription = motifDescription;
		this.motifDescriptionAr = motifDescriptionAr;
	}

	public Motif() {
		super();

	}

	
	//getters&setters
	public Integer getMotifId() {
		return motifId;
	}

	public void setMotifId(Integer motifId) {
		this.motifId = motifId;
	}

	public String getMotifLibelle() {
		return motifLibelle;
	}

	public void setMotifLibelle(String motifLibelle) {
		this.motifLibelle = motifLibelle;
	}

	public String getMotifLibelleAr() {
		return motifLibelleAr;
	}

	public void setMotifLibelleAr(String motifLibelleAr) {
		this.motifLibelleAr = motifLibelleAr;
	}

	public String getMotifCategorie() {
		return motifCategorie;
	}

	public void setMotifCategorie(String motifCategorie) {
		this.motifCategorie = motifCategorie;
	}
	
	@Column(name = "motifDescription", length = 1000)
	public String getMotifDescription() {
		return motifDescription;
	}

	public void setMotifDescription(String motifDescription) {
		this.motifDescription = motifDescription;
	}

	@Column(name = "motifDescriptionAr", length = 1000)
	public String getMotifDescriptionAr() {
		return motifDescriptionAr;
	}

	public void setMotifDescriptionAr(String motifDescriptionAr) {
		this.motifDescriptionAr = motifDescriptionAr;
	}

	
	
}
