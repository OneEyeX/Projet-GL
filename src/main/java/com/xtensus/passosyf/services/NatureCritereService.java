package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.NatureCritere;

public interface NatureCritereService {
	
	public List<NatureCritere> getAllNatureCriteres ();
	
	public NatureCritere getNatureCritereById (int id);

	public NatureCritere saveNatureCritere (NatureCritere natureCritere);

	public void deleteNatureCritere (NatureCritere natureCritere);

	public void deleteNatureCritereById (int id);

}
