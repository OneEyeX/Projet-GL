package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="devise")
public class Devise implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer deviseId ;
	
	private String deviseIdentifiant ;
	private String deviseNom ;
	private int deviseNbDecimale ;
	private String deviseNomDecimale ;
	
	
	//constructor
	public Devise(Integer deviseId, String deviseIdentifiant, String deviseNom, int deviseNbDecimale,
			String deviseNomDecimale) {
		super();
		this.deviseId = deviseId;
		this.deviseIdentifiant = deviseIdentifiant;
		this.deviseNom = deviseNom;
		this.deviseNbDecimale = deviseNbDecimale;
		this.deviseNomDecimale = deviseNomDecimale;
	}

	public Devise() {
		super();

	}

	//getters&setters
	public Integer getDeviseId() {
		return deviseId;
	}

	public void setDeviseId(Integer deviseId) {
		this.deviseId = deviseId;
	}

	public String getDeviseIdentifiant() {
		return deviseIdentifiant;
	}

	public void setDeviseIdentifiant(String deviseIdentifiant) {
		this.deviseIdentifiant = deviseIdentifiant;
	}

	public String getDeviseNom() {
		return deviseNom;
	}

	public void setDeviseNom(String deviseNom) {
		this.deviseNom = deviseNom;
	}

	public int getDeviseNbDecimale() {
		return deviseNbDecimale;
	}

	public void setDeviseNbDecimale(int deviseNbDecimale) {
		this.deviseNbDecimale = deviseNbDecimale;
	}

	public String getDeviseNomDecimale() {
		return deviseNomDecimale;
	}

	public void setDeviseNomDecimale(String deviseNomDecimale) {
		this.deviseNomDecimale = deviseNomDecimale;
	}
	
	

}
