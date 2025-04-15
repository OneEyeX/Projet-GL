package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Motif;

public interface MotifService {

	public List<Motif> getAllMotifs();
	
	public Motif getMotifById(int id);

	public Motif saveMotif(Motif motif);

	public void deleteMotif(Motif motif);

	public void deleteMotifById(int id);
}
