package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Fonction;

public interface FonctionService {

	public List<Fonction> getAllFonctions();
	
	public Fonction getFonctionById(int id);

	public Fonction saveFonction(Fonction fonction);

	public void deleteFonction(Fonction fonction);

	public void deleteFonctionById(int id);
}
