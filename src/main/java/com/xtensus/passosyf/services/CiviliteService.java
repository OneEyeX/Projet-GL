package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Civilite;

public interface CiviliteService {

	public List<Civilite> getAllCivilites();
	
	public Civilite getCiviliteByIdById(int id);

	public Civilite saveCivilite(Civilite civilite);

	public void deleteCivilite(Civilite civilite);

	public void deleteCiviliteById(int id);

}
