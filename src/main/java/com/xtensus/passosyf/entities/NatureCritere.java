package com.xtensus.passosyf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="naturecritere")
public class NatureCritere implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer natureCritereId;
	private String natureCritereLibelle;
	private String natureCritereLibelleAr;
	private String natureCritereDescription;
	private String natureCritereDescriptionAr;
	
	
	//constructor
	public NatureCritere(Integer natureCritereId, String natureCritereLibelle, String natureCritereLibelleAr,
			String natureCritereDescription, String natureCritereDescriptionAr) {
		super();
		this.natureCritereId = natureCritereId;
		this.natureCritereLibelle = natureCritereLibelle;
		this.natureCritereLibelleAr = natureCritereLibelleAr;
		this.natureCritereDescription = natureCritereDescription;
		this.natureCritereDescriptionAr = natureCritereDescriptionAr;
	}

	public NatureCritere() {
		super();
	}

	//getters&setters
	public Integer getNatureCritereId() {
		return natureCritereId;
	}

	public void setNatureCritereId(Integer natureCritereId) {
		this.natureCritereId = natureCritereId;
	}
	
	@Column(name="natureCritereLibelle",length = 100)
	public String getNatureCritereLibelle() {
		return natureCritereLibelle;
	}

	public void setNatureCritereLibelle(String natureCritereLibelle) {
		this.natureCritereLibelle = natureCritereLibelle;
	}
	
	@Column(name="natureCritereLibelleAr",length = 100)
	public String getNatureCritereLibelleAr() {
		return natureCritereLibelleAr;
	}

	public void setNatureCritereLibelleAr(String natureCritereLibelleAr) {
		this.natureCritereLibelleAr = natureCritereLibelleAr;
	}

	@Column(name="natureCritereDescription",length = 1000)
	public String getNatureCritereDescription() {
		return natureCritereDescription;
	}

	public void setNatureCritereDescription(String natureCritereDescription) {
		this.natureCritereDescription = natureCritereDescription;
	}

	@Column(name="natureCritereDescriptionAr",length = 1000)
	public String getNatureCritereDescriptionAr() {
		return natureCritereDescriptionAr;
	}

	public void setNatureCritereDescriptionAr(String natureCritereDescriptionAr) {
		this.natureCritereDescriptionAr = natureCritereDescriptionAr;
	}
	
	
	

}
