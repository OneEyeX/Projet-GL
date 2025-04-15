package com.xtensus.passosyf.servicesImp;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.xtensus.passosyf.entities.Pays;
import com.xtensus.passosyf.exceptions.NotFoundException;
import com.xtensus.passosyf.repositories.PaysRepository;
import com.xtensus.passosyf.services.PaysService;

@Service
@Transactional
public class PaysServiceImpl implements PaysService {
	
	@Autowired
	PaysRepository paysDao;
	
	
	@Override
	public List<Pays> getAllPays() {
		
		return paysDao.findAll();
	}
	
	
	@Override
	public Pays getPaysById(int id) {
		
		return paysDao.findById(id)
		        .orElseThrow (()-> new NotFoundException("Pays with ID : "+id+" Not Found!"));
	}
	

	@Override
	public Pays savePays(Pays pays) {
		
		return paysDao.save(pays);
	}


	@Override
	public void deletePaysById(int id) {
		
		paysDao.findById(id)
        .orElseThrow (()-> new NotFoundException("Pays with ID : "+id+" Not Found!"));
		
	        try {    
				paysDao.deleteById(id);
	            ResponseEntity.ok().body("Pays deleted with success!"); 

	    		}
	            catch (DataIntegrityViolationException e) {
	            	throw new DataIntegrityViolationException("Cannot delete Pays with ID \""+id+"\" because it is referenced by other objects ");
	            }

	}


	@Override
	public void deletePays(Pays pays) {

		paysDao.delete(pays);
	}




	}




