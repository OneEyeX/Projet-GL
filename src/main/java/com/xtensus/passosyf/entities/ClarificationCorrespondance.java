package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="clarificationcorrespondance")
public class ClarificationCorrespondance implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name="correspondanceclarificationId")
	private Integer correspondanceclarificationId ;
	
	@Column(length = 1000)
	private String correspondanceclrObjet ;
	@Column(length = 1000)
	private String correspondanceclrDescription ;
	private Date correspondanceclrDate;
	 
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etatId")
	private Etat correspondanceclrEtat;
	
	private String correspondanceclrType;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appelOffreId")
	private AppelOffres appelOffres;

	public ClarificationCorrespondance(Integer correspondanceclarificationId, String correspondanceclrObjet,
			String correspondanceclrDescription, Date correspondanceclrDate, Etat correspondanceclrEtat,
			String correspondanceclrType, AppelOffres appelOffres) {
		super();
		this.correspondanceclarificationId = correspondanceclarificationId;
		this.correspondanceclrObjet = correspondanceclrObjet;
		this.correspondanceclrDescription = correspondanceclrDescription;
		this.correspondanceclrDate = correspondanceclrDate;
		this.correspondanceclrEtat = correspondanceclrEtat;
		this.correspondanceclrType = correspondanceclrType;
		this.appelOffres = appelOffres;
	}
	
	public ClarificationCorrespondance() {
		super();

	}

	public Integer getCorrespondanceclarificationId() {
		return correspondanceclarificationId;
	}

	public void setCorrespondanceclarificationId(Integer correspondanceclarificationId) {
		this.correspondanceclarificationId = correspondanceclarificationId;
	}

	public String getCorrespondanceclrObjet() {
		return correspondanceclrObjet;
	}

	public void setCorrespondanceclrObjet(String correspondanceclrObjet) {
		this.correspondanceclrObjet = correspondanceclrObjet;
	}

	public String getCorrespondanceclrDescription() {
		return correspondanceclrDescription;
	}

	public void setCorrespondanceclrDescription(String correspondanceclrDescription) {
		this.correspondanceclrDescription = correspondanceclrDescription;
	}

	public Date getCorrespondanceclrDate() {
		return correspondanceclrDate;
	}

	public void setCorrespondanceclrDate(Date correspondanceclrDate) {
		this.correspondanceclrDate = correspondanceclrDate;
	}

	public Etat getCorrespondanceclrEtat() {
		return correspondanceclrEtat;
	}

	public void setCorrespondanceclrEtat(Etat correspondanceclrEtat) {
		this.correspondanceclrEtat = correspondanceclrEtat;
	}

	public String getCorrespondanceclrType() {
		return correspondanceclrType;
	}

	public void setCorrespondanceclrType(String correspondanceclrType) {
		this.correspondanceclrType = correspondanceclrType;
	}

	public AppelOffres getAppelOffres() {
		return appelOffres;
	}

	public void setAppelOffres(AppelOffres appelOffres) {
		this.appelOffres = appelOffres;
	}
	
	
	
	
}
