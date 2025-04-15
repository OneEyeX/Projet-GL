package com.xtensus.passosyf.servicesImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Pays;
import com.xtensus.passosyf.repositories.GouverneratRepository;
import com.xtensus.passosyf.services.GouverneratService;

@Service 
public class GouverneratServiceImpl implements GouverneratService {
	
	@Autowired
	GouverneratRepository gouverneratDao;

	@Override
	public List<Gouvernerat> getAllGouvernerats() {

		return gouverneratDao.findAll();
	}


	@Override
	public Gouvernerat getGouverneratById(int id) {

		return gouverneratDao.findById(id).get();
	}

	@Override
	public Gouvernerat saveGouvernerat(Gouvernerat gouvernerat) {

		return gouverneratDao.save(gouvernerat);
	}

	@Override
	public void deleteGouvernerat(Gouvernerat gouvernerat) {

		gouverneratDao.delete(gouvernerat);

	}

	@Override
	public void deleteGouverneratById(int id) {

        try {    
    		gouverneratDao.deleteById(id);
            ResponseEntity.ok().body("Gouvernerat deleted with success!"); 

    		}
            catch (DataIntegrityViolationException e) {
            	throw new DataIntegrityViolationException("Cannot delete Gouvernerat with ID \""+id+"\" because it is referenced by other objects ");
            }

	}

	@Override
	public Set<Gouvernerat> getAllGouverneratsByPays(Pays pays) {

		return gouverneratDao.findAllByPays(pays);

	}



}
