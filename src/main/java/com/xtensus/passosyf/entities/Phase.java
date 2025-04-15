package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="phase")
public class Phase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer phaseReference ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appelOffreReference")
	private AppelOffres appelOffre ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "lotReference")
	private Lot lot ;
	
	private String phaseLibelle ;
	private String phaseObjet ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tauxTVAId") 
	private TauxTVA tauxTVA ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "etatId") 
	private Etat etat ;
	
	private int phaseNumOrdre ;
	private int phaseDureeExecution ;
	private float phaseMontantHT ;
	
	
	//constructor
	public Phase(Integer phaseReference, AppelOffres appelOffre, Lot lot, String phaseLibelle, String phaseObjet,
			TauxTVA tauxTVA, Etat etat, int phaseNumOrdre, int phaseDureeExecution, float phaseMontantHT) {
		super();
		this.phaseReference = phaseReference;
		this.appelOffre = appelOffre;
		this.lot = lot;
		this.phaseLibelle = phaseLibelle;
		this.phaseObjet = phaseObjet;
		this.tauxTVA = tauxTVA;
		this.etat = etat;
		this.phaseNumOrdre = phaseNumOrdre;
		this.phaseDureeExecution = phaseDureeExecution;
		this.phaseMontantHT = phaseMontantHT;
	}

	public Phase() {
		super();

	}

	
	//getters&setters
	public Integer getPhaseReference() {
		return phaseReference;
	}

	public void setPhaseReference(Integer phaseReference) {
		this.phaseReference = phaseReference;
	}

	public AppelOffres getAppelOffre() {
		return appelOffre;
	}

	public void setAppelOffre(AppelOffres appelOffre) {
		this.appelOffre = appelOffre;
	}

	public Lot getLot() {
		return lot;
	}

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public String getPhaseLibelle() {
		return phaseLibelle;
	}

	public void setPhaseLibelle(String phaseLibelle) {
		this.phaseLibelle = phaseLibelle;
	}

	public String getPhaseObjet() {
		return phaseObjet;
	}

	public void setPhaseObjet(String phaseObjet) {
		this.phaseObjet = phaseObjet;
	}

	public TauxTVA getTauxTVA() {
		return tauxTVA;
	}

	public void setTauxTVA(TauxTVA tauxTVA) {
		this.tauxTVA = tauxTVA;
	}

	public Etat getEtat() {
		return etat;
	}

	public void setEtat(Etat etat) {
		this.etat = etat;
	}

	public int getPhaseNumOrdre() {
		return phaseNumOrdre;
	}

	public void setPhaseNumOrdre(int phaseNumOrdre) {
		this.phaseNumOrdre = phaseNumOrdre;
	}

	public int getPhaseDureeExecution() {
		return phaseDureeExecution;
	}

	public void setPhaseDureeExecution(int phaseDureeExecution) {
		this.phaseDureeExecution = phaseDureeExecution;
	}

	public float getPhaseMontantHT() {
		return phaseMontantHT;
	}

	public void setPhaseMontantHT(float phaseMontantHT) {
		this.phaseMontantHT = phaseMontantHT;
	}
	
	

}
