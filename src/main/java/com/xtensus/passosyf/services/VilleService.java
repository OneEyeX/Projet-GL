package com.xtensus.passosyf.services;

import java.util.List;
import java.util.Set;

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Ville;

public interface VilleService {
	
	public List<Ville> getAllVilles();
	
	public Ville getVilleById(int id);

	public Ville saveVille(Ville ville);

	public void deleteVille(Ville ville);

	public void deleteVilleById(int id);

	public Set<Ville> getVillesByGouvernerat(Gouvernerat gouvernerat);

	
	

}
