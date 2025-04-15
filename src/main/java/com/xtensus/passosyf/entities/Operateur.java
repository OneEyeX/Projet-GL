package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="operateur")
public class Operateur implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)	
	private Integer operateurId ;
	private String operateurNom ;
	
	
	//constructor
	public Operateur(Integer operateurId, String operateurNom) {
		super();
		this.operateurId = operateurId;
		this.operateurNom = operateurNom;
	}


	public Operateur() {
		super();
	}

	//getters&setters
	public Integer getOperateurId() {
		return operateurId;
	}

	public void setOperateurId(Integer operateurId) {
		this.operateurId = operateurId;
	}

	public String getOperateurNom() {
		return operateurNom;
	}

	public void setOperateurNom(String operateurNom) {
		this.operateurNom = operateurNom;
	}
	
	
	
	

}
