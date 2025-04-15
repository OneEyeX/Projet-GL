package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "representantlegaltitre")
public class RepresentantLegalTitre {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "representantLegalTitreId", unique = true, nullable = false)
	private int representantLegalTitreId;
	@Column(name = "representantLegalTitreLibelle")
	private String representantLegalTitreLibelle;
	@Column(name = "representantLegalTitreDescription")
	private String representantLegalTitreDescription;
	

	public int getRepresentantLegalTitreId() {
		return representantLegalTitreId;
	}
	
	public void setRepresentantLegalTitreId(int representantLegalTitreId) {
		this.representantLegalTitreId = representantLegalTitreId;
	}
	
	public String getRepresentantLegalTitreLibelle() {
		return representantLegalTitreLibelle;
	}
	
	public void setRepresentantLegalTitreLibelle(String representantLegalTitreLibelle) {
		this.representantLegalTitreLibelle = representantLegalTitreLibelle;
	}
	
	public String getRepresentantLegalTitreDescription() {
		return representantLegalTitreDescription;
	}
	
	public void setRepresentantLegalTitreDescription(String representantLegalTitreDescription) {
		this.representantLegalTitreDescription = representantLegalTitreDescription;
	}
	
	
	
}
