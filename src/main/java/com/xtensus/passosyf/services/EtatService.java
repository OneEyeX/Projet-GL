package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.entities.EtatCategorie;

public interface EtatService {
	
	public List<Etat> getAllEtats();
	
	public Etat getEtatById(int id);

	public Etat saveEtat(Etat etat);

	public void deleteEtat(Etat etat);

	public void deleteEtatById(int id);

	public List<Etat> getEtatsByEtatCategorie(EtatCategorie etatCategorie);

}
