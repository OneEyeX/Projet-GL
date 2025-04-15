package com.xtensus.passosyf.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="typecritere")
public class TypeCritere implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer typeCritereId;
	
	private String typeCritereNom;
	private String typeCritereNomAr;
	private String typeCritereDescription;
	private String typeCritereDescriptionAr;
	
	
	//constructor
	public TypeCritere(Integer typeCritereId, String typeCritereNom, String typeCritereNomAr,
			String typeCritereDescription, String typeCritereDescriptionAr) {
		super();
		this.typeCritereId = typeCritereId;
		this.typeCritereNom = typeCritereNom;
		this.typeCritereNomAr = typeCritereNomAr;
		this.typeCritereDescription = typeCritereDescription;
		this.typeCritereDescriptionAr = typeCritereDescriptionAr;
	}


	public TypeCritere() {
		super();
	}

	//getters&setters
	public Integer getTypeCritereId() {
		return typeCritereId;
	}

	public void setTypeCritereId(Integer typeCritereId) {
		this.typeCritereId = typeCritereId;
	}

	@Column(name="typeCritereNom",length = 100)
	public String getTypeCritereNom() {
		return typeCritereNom;
	}

	public void setTypeCritereNom(String typeCritereNom) {
		this.typeCritereNom = typeCritereNom;
	}

	@Column(name="typeCritereNomAr",length = 100)
	public String getTypeCritereNomAr() {
		return typeCritereNomAr;
	}

	public void setTypeCritereNomAr(String typeCritereNomAr) {
		this.typeCritereNomAr = typeCritereNomAr;
	}

	@Column(name="typeCritereDescription",length = 1000)
	public String getTypeCritereDescription() {
		return typeCritereDescription;
	}

	public void setTypeCritereDescription(String typeCritereDescription) {
		this.typeCritereDescription = typeCritereDescription;
	}

	@Column(name="typeCritereDescriptionAr",length = 1000)
	public String getTypeCritereDescriptionAr() {
		return typeCritereDescriptionAr;
	}

	public void setTypeCritereDescriptionAr(String typeCritereDescriptionAr) {
		this.typeCritereDescriptionAr = typeCritereDescriptionAr;
	}
	
	

}
