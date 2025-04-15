package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.EtatCategorie;

public interface EtatCategorieService {
	
	public List<EtatCategorie> getAllEtatCategories();
	
	public EtatCategorie getEtatCategorieById(int id);
	
	public EtatCategorie saveEtatCategorie(EtatCategorie etatCategorie);
	
	public void deleteEtatCategorieById(int id);
	
	public void deleteEtatCategorie(EtatCategorie etatCategorie);

	public EtatCategorie getEtatCategorieByEtatCategorieLibelle(String etatCategorieLibelle);

}
