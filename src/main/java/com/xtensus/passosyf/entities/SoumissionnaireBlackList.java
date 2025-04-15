package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

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
@Table(name="soumissionnaireblacklist")
public class SoumissionnaireBlackList {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer soumissionnaireBlackListId ;
	
	private Date soumissionnaireBlackListDateDebut ;
	private Date soumissionnaireBlackListDateFin ;
	@Column(name = "soumissionnaireBlackListDecision", length = 1000)
	private String soumissionnaireBlackListDecision ;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "blackListeMotiftId")
	private BlackListeMotif blackListeMotif;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "soumissionnaireId")
	private Soumissionnaire soumissionnaire;

	//Constructor
	public SoumissionnaireBlackList(Integer soumissionnaireBlackListId, Date soumissionnaireBlackListDateDebut,
			Date soumissionnaireBlackListDateFin, String soumissionnaireBlackListDecision,
			BlackListeMotif blackListeMotif, Soumissionnaire soumissionnaire) {
		super();
		this.soumissionnaireBlackListId = soumissionnaireBlackListId;
		this.soumissionnaireBlackListDateDebut = soumissionnaireBlackListDateDebut;
		this.soumissionnaireBlackListDateFin = soumissionnaireBlackListDateFin;
		this.soumissionnaireBlackListDecision = soumissionnaireBlackListDecision;
		this.blackListeMotif = blackListeMotif;
		this.soumissionnaire = soumissionnaire;
	}

	public SoumissionnaireBlackList() {
		super();

	}

	//getters&setters
	public Integer getSoumissionnaireBlackListId() {
		return soumissionnaireBlackListId;
	}

	public void setSoumissionnaireBlackListId(Integer soumissionnaireBlackListId) {
		this.soumissionnaireBlackListId = soumissionnaireBlackListId;
	}

	public Date getSoumissionnaireBlackListDateDebut() {
		return soumissionnaireBlackListDateDebut;
	}

	public void setSoumissionnaireBlackListDateDebut(Date soumissionnaireBlackListDateDebut) {
		this.soumissionnaireBlackListDateDebut = soumissionnaireBlackListDateDebut;
	}

	public Date getSoumissionnaireBlackListDateFin() {
		return soumissionnaireBlackListDateFin;
	}

	public void setSoumissionnaireBlackListDateFin(Date soumissionnaireBlackListDateFin) {
		this.soumissionnaireBlackListDateFin = soumissionnaireBlackListDateFin;
	}

	public String getSoumissionnaireBlackListDecision() {
		return soumissionnaireBlackListDecision;
	}

	public void setSoumissionnaireBlackListDecision(String soumissionnaireBlackListDecision) {
		this.soumissionnaireBlackListDecision = soumissionnaireBlackListDecision;
	}

	public BlackListeMotif getBlackListeMotif() {
		return blackListeMotif;
	}

	public void setBlackListeMotif(BlackListeMotif blackListeMotif) {
		this.blackListeMotif = blackListeMotif;
	}

	public Soumissionnaire getSoumissionnaire() {
		return soumissionnaire;
	}

	public void setSoumissionnaire(Soumissionnaire soumissionnaire) {
		this.soumissionnaire = soumissionnaire;
	}
	
	
}
