package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.TypeCritere;

public interface TypeCritereService {
	
	public List<TypeCritere> getAllTypeCriteres ();
	
	public TypeCritere getTypeCritereById (int id);

	public TypeCritere saveTypeCritere (TypeCritere typeCritere);

	public void deleteTypeCritere (TypeCritere typeCritere);

	public void deleteTypeCritereById (int id);

}
