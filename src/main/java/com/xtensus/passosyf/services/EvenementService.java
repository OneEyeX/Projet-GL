package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Evenement;

public interface EvenementService {

	public List<Evenement> getAllEvenements();
	
	public Evenement getEvenementById(int id);

	public Evenement saveEvenement(Evenement evenement);

	public void deleteEvenement(Evenement evenement);

	public void deleteEvenementById(int id);
}
