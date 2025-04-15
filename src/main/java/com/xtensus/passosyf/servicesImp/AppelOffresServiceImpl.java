package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.Etat;
import com.xtensus.passosyf.exceptions.NotFoundException;
import com.xtensus.passosyf.repositories.AppelOffresRepository;
import com.xtensus.passosyf.repositories.EtatRepository;
import com.xtensus.passosyf.services.AppelOffresService;

@Service
public class AppelOffresServiceImpl implements AppelOffresService {

	@Autowired
	AppelOffresRepository appelOffresDao;
	
	@Autowired
	EtatRepository etatDao;



	@Override
	public List<AppelOffres> getAllAppelOffres() {

		return appelOffresDao.findAll();
	}



	@Override
	public AppelOffres getAppelOffresById(int id) {

		return appelOffresDao.findById(id)
		        .orElseThrow (()-> new NotFoundException("AppelOffres with ID : "+id+" Not Found!"));
	}

	@Override
	public AppelOffres saveAppelOffres(AppelOffres appelOffres) {

		return appelOffresDao.save(appelOffres);
	}

	@Override
	public void deleteAppelOffres(AppelOffres appelOffres) {

		appelOffresDao.delete(appelOffres);

	}

	@Override
	public void deleteAppelOffresById(int id) {

        try {    
        	appelOffresDao.deleteById(id);
            ResponseEntity.ok().body("AppelOffres deleted with success!"); 

    		}
            catch (DataIntegrityViolationException e) {
            	throw new DataIntegrityViolationException("Cannot delete AppelOffres with ID \""+id+"\" because it is referenced by other objects ");
            }


	}
	
	
    @Override
    public Page<AppelOffres> getAllAppelOffres(int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return appelOffresDao.findAll(pageable);
    }

    
    
    @Override
    public Page<AppelOffres> searchAppelOffres(String search, int pageNum, int pageSize, String sortField, String sortDir) {
        Sort sort = Sort.by(sortField);
        if (sortDir.equalsIgnoreCase("desc")) {
            sort = sort.descending();
        }
        Pageable pageable = PageRequest.of(pageNum, pageSize, sort);
        return appelOffresDao.searchAppelOffres(search , pageable);
    }



	@Override
	public void setEtat(AppelOffres appelOffres, int etatId) {

		Etat etat = etatDao.findById(etatId).get();
		appelOffres.setEtat(etat);
	}
}
