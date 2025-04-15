package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.TypePV;

public interface TypePVService {
	
	public List<TypePV> getAllTypePVs();
	
	public TypePV getTypePVById(int id);

	public TypePV saveTypePV(TypePV typePV);

	public void deleteTypePV(TypePV typePV);

	public void deleteTypePVById(int id);
}
