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
@Table(name="gouvernerat")
public class Gouvernerat implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer gouverneratId ;
	
	private String gouverneratLibelle ;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "paysId")
	private Pays pays;
	
	
	//constructor
	public Gouvernerat(Integer gouverneratId, String gouverneratLibelle, Pays pays) {
		super();
		this.gouverneratId = gouverneratId;
		this.gouverneratLibelle = gouverneratLibelle;
		this.pays = pays;
	}

	public Gouvernerat() {
		super();
	}
	
	//getters&setters
	public Integer getGouverneratId() {
		return gouverneratId;
	}
	
	public void setGouverneratId(Integer gouverneratId) {
		this.gouverneratId = gouverneratId;
	}
	
	public String getGouverneratLibelle() {
		return gouverneratLibelle;
	}
	
	public void setGouverneratLibelle(String gouverneratLibelle) {
		this.gouverneratLibelle = gouverneratLibelle;
	}

	public Pays getPays() {
		return pays;
	}

	public void setPays(Pays pays) {
		this.pays = pays;
	}
	
	


	
	

}
