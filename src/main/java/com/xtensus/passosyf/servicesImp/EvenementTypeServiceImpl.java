package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.EvenementType;
import com.xtensus.passosyf.repositories.EvenementTypeRepository;
import com.xtensus.passosyf.services.EvenementTypeService;

@Service
public class EvenementTypeServiceImpl implements EvenementTypeService{

	@Autowired
	EvenementTypeRepository evenementTypeDao;

	@Override
	public List<EvenementType> getAllEvenementTypes() {

		return evenementTypeDao.findAll();
	}


	@Override
	public EvenementType getEvenementTypeById(int id) {

		return evenementTypeDao.findById(id).get();
	}

	@Override
	public EvenementType saveEvenementType(EvenementType evenementType) {

		return evenementTypeDao.save(evenementType);
	}

	@Override
	public void deleteEvenementType(EvenementType evenementType) {

		evenementTypeDao.delete(evenementType);

	}

	@Override
	public void deleteEvenementTypeById(int id) {

		evenementTypeDao.deleteById(id);

	}
}
