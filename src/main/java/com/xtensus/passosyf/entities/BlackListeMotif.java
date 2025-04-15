package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="blacklistemotif")
public class BlackListeMotif {
	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Integer blackListeMotiftId ;
	
	@Column(name = "blackListeMotifLibelle", length = 100)
	private String blackListeMotifLibelle ;
	@Column(name = "blackListeMotifDescription", length = 1000)
	private String blackListeMotifDescription ;
	
	
	//Constructor
	public BlackListeMotif(Integer blackListeMotiftId, String blackListeMotifLibelle,
			String blackListeMotifDescription) {
		super();
		this.blackListeMotiftId = blackListeMotiftId;
		this.blackListeMotifLibelle = blackListeMotifLibelle;
		this.blackListeMotifDescription = blackListeMotifDescription;
	}

	public BlackListeMotif() {
		super();

	}

	//getters&setters
	public Integer getBlackListeMotiftId() {
		return blackListeMotiftId;
	}

	public void setBlackListeMotiftId(Integer blackListeMotiftId) {
		this.blackListeMotiftId = blackListeMotiftId;
	}

	public String getBlackListeMotifLibelle() {
		return blackListeMotifLibelle;
	}

	public void setBlackListeMotifLibelle(String blackListeMotifLibelle) {
		this.blackListeMotifLibelle = blackListeMotifLibelle;
	}

	public String getBlackListeMotifDescription() {
		return blackListeMotifDescription;
	}

	public void setBlackListeMotifDescription(String blackListeMotifDescription) {
		this.blackListeMotifDescription = blackListeMotifDescription;
	}

	
}
