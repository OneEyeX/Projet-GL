package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.CategoriesProjet;

public interface CategoriesProjetService {

	public List<CategoriesProjet> getAllCategoriesProjets();
	
	public CategoriesProjet getCategoriesProjetById(int id);

	public CategoriesProjet saveCategoriesProjet(CategoriesProjet categoriesProjet);

	public void deleteCategoriesProjet(CategoriesProjet categoriesProjet);

	public void deleteCategoriesProjetById(int id);
}
