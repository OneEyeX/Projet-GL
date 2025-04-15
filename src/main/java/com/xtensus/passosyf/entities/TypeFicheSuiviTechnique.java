package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typefichesuivitechnique")
public class TypeFicheSuiviTechnique implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)	
	private Integer typeFicheSuiviTechniqueId ;
	
	private String typeFicheSuiviTechniqueLibelle ;
	private String typeFicheSuiviTechniqueLibelleAr ;
	
	
	//constructor
	public TypeFicheSuiviTechnique(Integer typeFicheSuiviTechniqueId, String typeFicheSuiviTechniqueLibelle , String typeFicheSuiviTechniqueLibelleAr) {
		super();
		this.typeFicheSuiviTechniqueId = typeFicheSuiviTechniqueId;
		this.typeFicheSuiviTechniqueLibelle = typeFicheSuiviTechniqueLibelle;
		this.typeFicheSuiviTechniqueLibelleAr=typeFicheSuiviTechniqueLibelleAr;
	}
	
	public TypeFicheSuiviTechnique() {
		super();
	}
	
	//getters&setters
	public Integer getTypeFicheSuiviTechniqueId() {
		return typeFicheSuiviTechniqueId;
	}
	
	public void setTypeFicheSuiviTechniqueId(Integer typeFicheSuiviTechniqueId) {
		this.typeFicheSuiviTechniqueId = typeFicheSuiviTechniqueId;
	}
	
	public String getTypeFicheSuiviTechniqueLibelle() {
		return typeFicheSuiviTechniqueLibelle;
	}
	
	public void setTypeFicheSuiviTechniqueLibelle(String typeFicheSuiviTechniqueLibelle) {
		this.typeFicheSuiviTechniqueLibelle = typeFicheSuiviTechniqueLibelle;
	}

	public String getTypeFicheSuiviTechniqueLibelleAr() {
		return typeFicheSuiviTechniqueLibelleAr;
	}

	public void setTypeFicheSuiviTechniqueLibelleAr(String typeFicheSuiviTechniqueLibelleAr) {
		this.typeFicheSuiviTechniqueLibelleAr = typeFicheSuiviTechniqueLibelleAr;
	}
	
	


}
