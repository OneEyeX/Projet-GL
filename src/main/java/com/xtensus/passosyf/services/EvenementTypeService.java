package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.EvenementType;

public interface EvenementTypeService {

	public List<EvenementType> getAllEvenementTypes();
	
	public EvenementType getEvenementTypeById(int id);

	public EvenementType saveEvenementType(EvenementType evenementType);

	public void deleteEvenementType(EvenementType evenementType);

	public void deleteEvenementTypeById(int id);
}
