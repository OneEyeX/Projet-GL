package com.xtensus.passosyf.servicesImp;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.EtatCategorie;
import com.xtensus.passosyf.repositories.EtatCategorieRepository;
import com.xtensus.passosyf.services.EtatCategorieService;

@Service
@Transactional
public class EtatCategorieServiceImpl implements EtatCategorieService {
	
	@Autowired
	EtatCategorieRepository etatCategorieDao;
	
	
	@Override
	public List<EtatCategorie> getAllEtatCategories() {
		
		return etatCategorieDao.findAll();
	}
	
	
	@Override
	public EtatCategorie getEtatCategorieById(int id) {
		
		return etatCategorieDao.findById(id).get();
	}
	

	@Override
	public EtatCategorie saveEtatCategorie(EtatCategorie etatCategorie) {
		
		return etatCategorieDao.save(etatCategorie);
	}


	@Override
	public void deleteEtatCategorieById(int id) {
		
		try {
			etatCategorieDao.deleteById(id);
			 new ResponseEntity<>("",HttpStatus.OK);
		}
		catch (Exception e) {
			 new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST); 
		}
	}


	@Override
	public void deleteEtatCategorie(EtatCategorie etatCategorie) {

		etatCategorieDao.delete(etatCategorie);
	}


	@Override
	public EtatCategorie getEtatCategorieByEtatCategorieLibelle(String etatCategorieLibelle) {

		return etatCategorieDao.findByEtatCategorieLibelle(etatCategorieLibelle).get();
	}

}
