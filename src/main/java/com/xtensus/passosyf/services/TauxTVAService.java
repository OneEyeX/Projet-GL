package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.TauxTVA;

public interface TauxTVAService {

	public List<TauxTVA> getAllTauxTVAs();
	
	public TauxTVA getTauxTVAById(int id);

	public TauxTVA saveTauxTVA(TauxTVA tauxTVA);

	public void deleteTauxTVA(TauxTVA tauxTVA);

	public void deleteTauxTVAById(int id);
}
