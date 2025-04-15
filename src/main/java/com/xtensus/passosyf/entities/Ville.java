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
@Table(name="ville")
public class Ville implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	
	private Integer villeId ;
	private String villeNom ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "gouverneratId")
	private Gouvernerat gouvernerat;
	
	

	//constructor
	public Ville(Integer villeId, String villeNom, Gouvernerat gouvernerat) {
		super();
		this.villeId = villeId;
		this.villeNom = villeNom;
		this.gouvernerat = gouvernerat;
	}
	 
	public Ville() {
		super();
	}
	
	//getters&setters
	public Integer getVilleId() {
		return villeId;
	}
	
	public void setVilleId(Integer villeId) {
		this.villeId = villeId;
	}
	
	public String getVilleNom() {
		return villeNom;
	}
	
	public void setVilleNom(String villeNom) {
		this.villeNom = villeNom;
	}
	
	public Gouvernerat getGouvernerat() {
		return gouvernerat;
	}

	public void setGouvernerat(Gouvernerat gouvernerat) {
		this.gouvernerat = gouvernerat;
	}
	
	

}
