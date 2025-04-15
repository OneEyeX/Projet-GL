package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Operateur;
import com.xtensus.passosyf.exceptions.NotFoundException;
import com.xtensus.passosyf.repositories.OperateurRepository;
import com.xtensus.passosyf.services.OperateurService;

@Service
public class OperateurServiceImpl implements OperateurService{

	
	@Autowired
	OperateurRepository operateurDao;
	
	@Override
	public List<Operateur> getAllOperateurs() {

		return operateurDao.findAll();
	}

	@Override
	public Operateur getOperateurById(int id) {

		return operateurDao.findById(id)
		        .orElseThrow (()-> new NotFoundException("Operateur with ID : "+id+" Not Found!"));
	}

	@Override
	public Operateur saveOperateur(Operateur operateur) {

		return operateurDao.save(operateur);
	}

	@Override
	public void deleteOperateur(Operateur operateur) {

		operateurDao.delete(operateur);

	}

	@Override
	public void deleteOperateurById(int id) {

		operateurDao.findById(id)
        .orElseThrow (()-> new NotFoundException("Operateur with ID : "+id+" Not Found!"));
		
	        try {    
	        	operateurDao.deleteById(id);
	            ResponseEntity.ok().body("Operateur deleted with success!"); 

	    		}
	            catch (DataIntegrityViolationException e) {
	            	throw new DataIntegrityViolationException("Cannot delete Operateur with ID \""+id+"\" because it is referenced by other objects ");
	            }

	}

}
