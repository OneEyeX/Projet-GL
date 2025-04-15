package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Critere;

public interface CritereService {
	
	public List<Critere> getAllCritere();
	
	public Critere getCritereById(int id);
	
	public Critere saveCritere(Critere critere);
	
	public void deleteCritereById(int id);
	
	public void deleteCritere(Critere critere);


}
