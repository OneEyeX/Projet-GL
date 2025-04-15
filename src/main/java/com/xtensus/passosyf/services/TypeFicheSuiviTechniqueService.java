package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.TypeFicheSuiviTechnique;

public interface TypeFicheSuiviTechniqueService {
	
	public List<TypeFicheSuiviTechnique> getAllTypeFicheSuiviTechniques();
	
	public TypeFicheSuiviTechnique getTypeFicheSuiviTechniqueById(int id);

	public TypeFicheSuiviTechnique saveTypeFicheSuiviTechnique(TypeFicheSuiviTechnique typeFicheSuiviTechnique);

	public void deleteTypeFicheSuiviTechnique(TypeFicheSuiviTechnique typeFicheSuiviTechnique);

	public void deleteTypeFicheSuiviTechniqueById(int id);

}
