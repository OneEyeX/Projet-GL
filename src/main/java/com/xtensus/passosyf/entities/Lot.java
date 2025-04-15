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
@Table(name="lot")
public class Lot implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer lotReference ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appelOffreReference")
	private AppelOffres appelOffre ;
	
	@Column(name="lotCode", length=100)
	private String lotCode ;
	private String lotLibelle ;
	private String lotObjet ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "secteurActiviteeId") //secteurActiviteeId
	private SecteurActivite secteurActivite ;
	
	private int lotNombrePhases ;
	private int lotDureeExecution ;
	private float lotMontantHT ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tauxTVAId")
	private TauxTVA tauxTVA ;
	
	

	
	//constructor
	public Lot(Integer lotReference, AppelOffres appelOffre, String lotLibelle, String lotObjet,
			SecteurActivite secteurActivite, int lotNombrePhases, int lotDureeExecution, float lotMontantHT,
			TauxTVA tauxTVA,String lotCode) {
		super();
		this.lotReference = lotReference;
		this.appelOffre = appelOffre;
		this.lotLibelle = lotLibelle;
		this.lotObjet = lotObjet;
		this.secteurActivite = secteurActivite;
		this.lotNombrePhases = lotNombrePhases;
		this.lotDureeExecution = lotDureeExecution;
		this.lotMontantHT = lotMontantHT;
		this.tauxTVA = tauxTVA;
		this.lotCode=lotCode;
	}

	public Lot() {
		super();

	}

	//getters&setters
	public Integer getLotReference() {
		return lotReference;
	}

	public void setLotReference(Integer lotReference) {
		this.lotReference = lotReference;
	}

	public AppelOffres getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffres appelOffre) {
		this.appelOffre = appelOffre;
	}

	public String getLotLibelle() {
		return lotLibelle;
	}

	public void setLotLibelle(String lotLibelle) {
		this.lotLibelle = lotLibelle;
	}

	public String getLotObjet() {
		return lotObjet;
	}

	public void setLotObjet(String lotObjet) {
		this.lotObjet = lotObjet;
	}

	public SecteurActivite getSecteurActivite() {
		return secteurActivite;
	}

	public void setSecteurActivite(SecteurActivite secteurActivite) {
		this.secteurActivite = secteurActivite;
	}

	public int getLotNombrePhases() {
		return lotNombrePhases;
	}

	public void setLotNombrePhases(int lotNombrePhases) {
		this.lotNombrePhases = lotNombrePhases;
	}

	public int getLotDureeExecution() {
		return lotDureeExecution;
	}

	public void setLotDureeExecution(int lotDureeExecution) {
		this.lotDureeExecution = lotDureeExecution;
	}

	public float getLotMontantHT() {
		return lotMontantHT;
	}

	public void setLotMontantHT(float lotMontantHT) {
		this.lotMontantHT = lotMontantHT;
	}

	public TauxTVA getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(TauxTVA tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	public String getLotCode() {
		return lotCode;
	}

	public void setLotCode(String lotCode) {
		this.lotCode = lotCode;
	}
	
	

	

	

	
	
	


}
