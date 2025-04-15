package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.CategorieProjet;

public interface CategorieProjetService {
	
	public List<CategorieProjet> getAllCategorieProjets();
	
	public CategorieProjet getCategorieProjetById(int id);

	public CategorieProjet saveCategorieProjet(CategorieProjet categorieProjet);

	public void deleteCategorieProjet(CategorieProjet categorieProjet);

	public void deleteCategorieProjetById(int id);
}
