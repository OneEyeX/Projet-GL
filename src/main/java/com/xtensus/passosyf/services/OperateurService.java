package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.Operateur;

public interface OperateurService {
	
	
	public List<Operateur> getAllOperateurs();
	
	public Operateur getOperateurById(int id);

	public Operateur saveOperateur(Operateur operateur);

	public void deleteOperateur(Operateur operateur);

	public void deleteOperateurById(int id);

}
