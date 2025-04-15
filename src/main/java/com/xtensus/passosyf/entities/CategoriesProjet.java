package com.xtensus.passosyf.entities;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoriesprojet")
public class CategoriesProjet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private int categoriesProjetId;
	
	private String categoriesProjetLibelle;
	private String categoriesProjetDescription;
	
	
	//constructor
	public CategoriesProjet(int categoriesProjetId, String categoriesProjetLibelle,
			String categoriesProjetDescription) {
		super();
		this.categoriesProjetId = categoriesProjetId;
		this.categoriesProjetLibelle = categoriesProjetLibelle;
		this.categoriesProjetDescription = categoriesProjetDescription;
	}

	public CategoriesProjet() {
		super();

	}

	//getters&setters
	public int getCategoriesProjetId() {
		return categoriesProjetId;
	}

	public void setCategoriesProjetId(int categoriesProjetId) {
		this.categoriesProjetId = categoriesProjetId;
	}

	@Column(name="categoriesProjetLibelle",length = 100)
	public String getCategoriesProjetLibelle() {
		return categoriesProjetLibelle;
	}

	public void setCategoriesProjetLibelle(String categoriesProjetLibelle) {
		this.categoriesProjetLibelle = categoriesProjetLibelle;
	}
	
	@Column(name="categoriesProjetDescription",length = 1000)
	public String getCategoriesProjetDescription() {
		return categoriesProjetDescription;
	}

	public void setCategoriesProjetDescription(String categoriesProjetDescription) {
		this.categoriesProjetDescription = categoriesProjetDescription;
	}
	
	


}
