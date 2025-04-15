package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.TypeFicheSuiviTechnique;
import com.xtensus.passosyf.repositories.TypeFicheSuiviTechniqueRepository;
import com.xtensus.passosyf.services.TypeFicheSuiviTechniqueService;

@Service
public class TypeFicheSuiviTechniqueServiceImpl implements TypeFicheSuiviTechniqueService {
	
	@Autowired
	TypeFicheSuiviTechniqueRepository typeFicheSuiviTechniqueDao;

	@Override
	public List<TypeFicheSuiviTechnique> getAllTypeFicheSuiviTechniques() {

		return typeFicheSuiviTechniqueDao.findAll();
	}

	@Override
	public TypeFicheSuiviTechnique getTypeFicheSuiviTechniqueById(int id) {

		return typeFicheSuiviTechniqueDao.findById(id).get();
	}

	@Override
	public TypeFicheSuiviTechnique saveTypeFicheSuiviTechnique(TypeFicheSuiviTechnique typeFicheSuiviTechnique) {

		return typeFicheSuiviTechniqueDao.save(typeFicheSuiviTechnique);
	}

	@Override
	public void deleteTypeFicheSuiviTechnique(TypeFicheSuiviTechnique typeFicheSuiviTechnique) {

		typeFicheSuiviTechniqueDao.delete(typeFicheSuiviTechnique);

	}

	@Override
	public void deleteTypeFicheSuiviTechniqueById(int id) {

		typeFicheSuiviTechniqueDao.deleteById(id);

	}

}
