package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.TypeLettre;

public interface TypeLettreService {
	
	public List<TypeLettre> getAllTypeLettres();
	
	public TypeLettre getTypeLettreById(int id);

	public TypeLettre saveTypeLettre(TypeLettre typeLettre);

	public void deleteTypeLettre(TypeLettre typeLettre);

	public void deleteTypeLettreById(int id);

}
