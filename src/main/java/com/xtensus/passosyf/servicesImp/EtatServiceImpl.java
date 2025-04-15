package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.entities.EtatCategorie;
import com.xtensus.passosyf.exceptions.NotFoundException;
import com.xtensus.passosyf.repositories.EtatRepository;
import com.xtensus.passosyf.services.EtatService;

@Service
public class EtatServiceImpl implements EtatService {
	
	@Autowired
	EtatRepository etatDao;

	@Override
	public List<Etat> getAllEtats() {

		return etatDao.findAll();
	}


	@Override
	public Etat getEtatById(int id) {

		return etatDao.findById(id)
		        .orElseThrow (()-> new NotFoundException("Etat with ID : "+id+" Not Found!"));
	}

	@Override
	public Etat saveEtat(Etat etat) {

		return etatDao.save(etat);
	}

	@Override
	public void deleteEtat(Etat etat) {

		etatDao.delete(etat);

	}

	@Override
	public void deleteEtatById(int id) {

		etatDao.deleteById(id);
		
		etatDao.findById(id)
        .orElseThrow (()-> new NotFoundException("Etat with ID : "+id+" Not Found!"));
		
	        try {    
	    		etatDao.deleteById(id);
	            ResponseEntity.ok().body("Etat deleted with success!"); 

	    		}
	            catch (DataIntegrityViolationException e) {
	            	throw new DataIntegrityViolationException("Cannot delete Etat with ID \""+id+"\" because it is referenced by other objects ");
	            }

	}


	@Override
	public List<Etat> getEtatsByEtatCategorie(EtatCategorie etatCategorie) {

		return etatDao.findAllByEtatCategorie(etatCategorie);
	}

}
