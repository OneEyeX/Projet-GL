package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categorieprojet")
public class CategorieProjet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int categorieProjetId;
	
	private String categorieProjetLibelle;
	private String categorieProjetEnsembleCritere;
	private String categorieProjetDescription;
	
	//constructor
	public CategorieProjet(int categorieProjetId, String categorieProjetLibelle, String categorieProjetEnsembleCritere,
			String categorieProjetDescription) {
		super();
		this.categorieProjetId = categorieProjetId;
		this.categorieProjetLibelle = categorieProjetLibelle;
		this.categorieProjetEnsembleCritere = categorieProjetEnsembleCritere;
		this.categorieProjetDescription = categorieProjetDescription;
	}

	public CategorieProjet() {
		super();

	}

	//getters&setters
	public int getCategorieProjetId() {
		return categorieProjetId;
	}

	public void setCategorieProjetId(int categorieProjetId) {
		this.categorieProjetId = categorieProjetId;
	}

	public String getCategorieProjetLibelle() {
		return categorieProjetLibelle;
	}

	public void setCategorieProjetLibelle(String categorieProjetLibelle) {
		this.categorieProjetLibelle = categorieProjetLibelle;
	}

	public String getCategorieProjetEnsembleCritere() {
		return categorieProjetEnsembleCritere;
	}

	public void setCategorieProjetEnsembleCritere(String categorieProjetEnsembleCritere) {
		this.categorieProjetEnsembleCritere = categorieProjetEnsembleCritere;
	}

	public String getCategorieProjetDescription() {
		return categorieProjetDescription;
	}

	public void setCategorieProjetDescription(String categorieProjetDescription) {
		this.categorieProjetDescription = categorieProjetDescription;
	}
	
	

}
