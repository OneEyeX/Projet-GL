package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "nature")
public class Nature implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "natureId", unique = true, nullable = false)
	private Integer natureId ;
	
	private String natureLibelle ;
	private String natureCategorie ;
	private String natureDescription ;
	
	
	//constructor
	public Nature(Integer natureId, String natureLibelle, String natureCategorie, String natureDescription) {
		super();
		this.natureId = natureId;
		this.natureLibelle = natureLibelle;
		this.natureCategorie = natureCategorie;
		this.natureDescription = natureDescription;
	}


	public Nature() {
		super();
	}

	
	
	//getters&setters
	public Integer getNatureId() {
		return natureId;
	}

	public void setNatureId(Integer natureId) {
		this.natureId = natureId;
	}

	@Column(name="natureLibelle",length = 100)
	public String getNatureLibelle() {
		return natureLibelle;
	}

	public void setNatureLibelle(String natureLibelle) {
		this.natureLibelle = natureLibelle;
	}

	@Column(name="natureCategorie",length = 100)
	public String getNatureCategorie() {
		return natureCategorie;
	}

	public void setNatureCategorie(String natureCategorie) {
		this.natureCategorie = natureCategorie;
	}

	@Column(name="natureDescription",length = 1000)
	public String getNatureDescription() {
		return natureDescription;
	}

	public void setNatureDescription(String natureDescription) {
		this.natureDescription = natureDescription;
	}
	
	
	
	


}
