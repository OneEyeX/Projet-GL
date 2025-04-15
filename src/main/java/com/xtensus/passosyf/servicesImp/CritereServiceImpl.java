package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Critere;
import com.xtensus.passosyf.repositories.CritereRepository;
import com.xtensus.passosyf.services.CritereService;

@Service
public class CritereServiceImpl implements CritereService {
	
	@Autowired
	CritereRepository critereDao;

	@Override
	public List<Critere> getAllCritere() {

		return critereDao.findAll();
	}

	@Override
	public Critere getCritereById(int id) {

		return critereDao.findById(id).get();
	}

	@Override
	public Critere saveCritere(Critere critere) {

		return critereDao.save(critere);
	}

	@Override
	public void deleteCritereById(int id) {

		try {
			critereDao.deleteById(id);
			 new ResponseEntity<>("",HttpStatus.OK);
		}
		catch (Exception e) {
		     new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST); 
		}	}

	@Override
	public void deleteCritere(Critere critere) {
		
		critereDao.delete(critere);
		
	}

}
