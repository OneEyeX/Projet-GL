package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tauxtva")
public class TauxTVA implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer tauxTVAId ;
	private float tauxTVAValeur ;
	
	//constructor
	public TauxTVA(Integer tauxTVAId, float tauxTVAValeur) {
		super();
		this.tauxTVAId = tauxTVAId;
		this.tauxTVAValeur = tauxTVAValeur;
	}


	public TauxTVA() {
		super();

	}

	//getters&setters
	public Integer getTauxTVAId() {
		return tauxTVAId;
	}


	public void setTauxTVAId(Integer tauxTVAId) {
		this.tauxTVAId = tauxTVAId;
	}


	public float getTauxTVAValeur() {
		return tauxTVAValeur;
	}


	public void setTauxTVAValeur(float tauxTVAValeur) {
		this.tauxTVAValeur = tauxTVAValeur;
	}
	
	
}
