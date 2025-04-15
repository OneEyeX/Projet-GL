package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Fonction;
import com.xtensus.passosyf.repositories.FonctionRepository;
import com.xtensus.passosyf.services.FonctionService;


@Service
public class FonctionServiceImpl implements FonctionService {

	@Autowired
	FonctionRepository fonctionDao;

	@Override
	public List<Fonction> getAllFonctions() {

		return fonctionDao.findAll();
	}


	@Override
	public Fonction getFonctionById(int id) {

		return fonctionDao.findById(id).get();
	}

	@Override
	public Fonction saveFonction(Fonction fonction) {

		return fonctionDao.save(fonction);
	}

	@Override
	public void deleteFonction(Fonction fonction) {

		fonctionDao.delete(fonction);

	}

	@Override
	public void deleteFonctionById(int id) {

		fonctionDao.deleteById(id);

	}
}
