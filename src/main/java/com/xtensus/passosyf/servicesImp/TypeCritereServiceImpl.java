package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.TypeCritere;
import com.xtensus.passosyf.exceptions.NotFoundException;
import com.xtensus.passosyf.repositories.TypeCritereRepository;
import com.xtensus.passosyf.services.TypeCritereService;

@Service
public class TypeCritereServiceImpl implements TypeCritereService {

	
	@Autowired
	TypeCritereRepository typeCritereDao;
	
	
	@Override
	public List<TypeCritere> getAllTypeCriteres() {

		return typeCritereDao.findAll();
	}

	@Override
	public TypeCritere getTypeCritereById(int id) {

		return typeCritereDao.findById(id).orElseThrow (()-> new NotFoundException("TypeCritere with ID : "+id+" Not Found!"));
	}

	@Override
	public TypeCritere saveTypeCritere(TypeCritere typeCritere) {

		return typeCritereDao.save(typeCritere);
	}

	@Override
	public void deleteTypeCritere(TypeCritere typeCritere) {

		typeCritereDao.delete(typeCritere);

	}

	@Override
	public void deleteTypeCritereById(int id) {

		typeCritereDao.findById(id)
        .orElseThrow (()-> new NotFoundException("TypeCritere with ID : "+id+" Not Found!"));
		
	        try {    
	        	typeCritereDao.deleteById(id);
	            ResponseEntity.ok().body("TypeCritere deleted with success!"); 

	    		}
	            catch (DataIntegrityViolationException e) {
	            	throw new DataIntegrityViolationException("Cannot delete TypeCritere with ID \""+id+"\" because it is referenced by other objects ");
	            }

	}

}
