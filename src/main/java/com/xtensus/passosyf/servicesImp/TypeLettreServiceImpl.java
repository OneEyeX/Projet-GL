package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.TypeLettre;
import com.xtensus.passosyf.repositories.TypeLettreRepository;
import com.xtensus.passosyf.services.TypeLettreService;

@Service
public class TypeLettreServiceImpl implements TypeLettreService {

	
	@Autowired
	TypeLettreRepository typeLettreDao;
	
	
	@Override
	public List<TypeLettre> getAllTypeLettres() {

		return typeLettreDao.findAll();
	}

	@Override
	public TypeLettre getTypeLettreById(int id) {

		return typeLettreDao.findById(id).get();
	}

	@Override
	public TypeLettre saveTypeLettre(TypeLettre typeLettre) {

		return typeLettreDao.save(typeLettre);
	}

	@Override
	public void deleteTypeLettre(TypeLettre typeLettre) {

		typeLettreDao.delete(typeLettre);

	}

	@Override
	public void deleteTypeLettreById(int id) {

		typeLettreDao.deleteById(id);

	}

}
