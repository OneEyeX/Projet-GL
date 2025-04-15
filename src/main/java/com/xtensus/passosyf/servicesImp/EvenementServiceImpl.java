package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Evenement;
import com.xtensus.passosyf.repositories.EvenementRepository;
import com.xtensus.passosyf.services.EvenementService;


@Service
public class EvenementServiceImpl implements EvenementService {

	@Autowired
	EvenementRepository evenementDao;

	@Override
	public List<Evenement> getAllEvenements() {

		return evenementDao.findAll();
	}


	@Override
	public Evenement getEvenementById(int id) {

		return evenementDao.findById(id).get();
	}

	@Override
	public Evenement saveEvenement(Evenement evenement) {

		return evenementDao.save(evenement);
	}

	@Override
	public void deleteEvenement(Evenement evenement) {

		evenementDao.delete(evenement);

	}

	@Override
	public void deleteEvenementById(int id) {

		evenementDao.deleteById(id);

	}
}
