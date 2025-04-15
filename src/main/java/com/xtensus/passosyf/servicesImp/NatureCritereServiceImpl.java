package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.NatureCritere;
import com.xtensus.passosyf.repositories.NatureCritereRepository;
import com.xtensus.passosyf.services.NatureCritereService;

@Service
public class NatureCritereServiceImpl implements NatureCritereService {

	
	@Autowired
	NatureCritereRepository natureCritereDao;
	
	@Override
	public List<NatureCritere> getAllNatureCriteres() {
		
		return natureCritereDao.findAll();
	}

	@Override
	public NatureCritere getNatureCritereById(int id) {

		return natureCritereDao.findById(id).get();
	}

	@Override
	public NatureCritere saveNatureCritere(NatureCritere natureCritere) {

		return natureCritereDao.save(natureCritere);
	}

	@Override
	public void deleteNatureCritere (NatureCritere natureCritere) {

		natureCritereDao.delete(natureCritere);

	}

	@Override
	public void deleteNatureCritereById(int id) {

        try {    
    		natureCritereDao.deleteById(id);
            ResponseEntity.ok().body("NatureCritere deleted with success!"); 

    		}
            catch (DataIntegrityViolationException e) {
            	throw new DataIntegrityViolationException("Cannot delete NatureCritere with ID \""+id+"\" because it is referenced by other objects ");
            }

	}

}
