package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;



//@Data
//@AllArgsConstructor
//@NoArgsConstructor
@Entity
@Table(name = "civilite")
public class Civilite implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int civiliteId;
	
	private String civiliteLibelle;
	private String civiliteAcronyme;
	private String civiliteLibellear;
	private String civiliteAcronymear;
  
	
	
	//constructor
	public Civilite(String civiliteLibelle, String civiliteAcronyme, String civiliteLibellear,
			String civiliteAcronymear) {
		super();
		this.civiliteLibelle = civiliteLibelle;
		this.civiliteAcronyme = civiliteAcronyme;
		this.civiliteLibellear = civiliteLibellear;
		this.civiliteAcronymear = civiliteAcronymear;
	}

	public Civilite() {
		super();
	}

	public int getCiviliteId() {
		return civiliteId;
	}
	
	public void setCiviliteId(int civiliteId) {
		this.civiliteId = civiliteId;
	}
	
	public String getCiviliteLibelle() {
		return civiliteLibelle;
	}
	
	public void setCiviliteLibelle(String civiliteLibelle) {
		this.civiliteLibelle = civiliteLibelle;
	}
	
	public String getCiviliteAcronyme() {
		return civiliteAcronyme;
	}
	
	public void setCiviliteAcronyme(String civiliteAcronyme) {
		this.civiliteAcronyme = civiliteAcronyme;
	}
	
	public String getCiviliteLibellear() {
		return civiliteLibellear;
	}
	
	public void setCiviliteLibellear(String civiliteLibellear) {
		this.civiliteLibellear = civiliteLibellear;
	}
	
	public String getCiviliteAcronymear() {
		return civiliteAcronymear;
	}
	
	public void setCiviliteAcronymear(String civiliteAcronymear) {
		this.civiliteAcronymear = civiliteAcronymear;
	}
	
	
	

}
