package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Civilite;
import com.xtensus.passosyf.repositories.CiviliteRepository;
import com.xtensus.passosyf.services.CiviliteService;


@Service
public class CiviliteServiceImpl implements CiviliteService{
	
	@Autowired
	CiviliteRepository civiliteDao;

	
	@Override
	public List <Civilite> getAllCivilites() {

		return civiliteDao.findAll();
	}
	
	@Override
	public Civilite getCiviliteByIdById(int id) {

		return civiliteDao.findById(id).get();
	}


	@Override
	public Civilite saveCivilite(Civilite civilite) {
		
		return civiliteDao.save(civilite);
		
	}

	@Override
	public void deleteCivilite(Civilite civilite) {

		civiliteDao.delete(civilite);
	}

	@Override
	public void deleteCiviliteById(int id) {

		civiliteDao.deleteById(id);
	}
	


}
