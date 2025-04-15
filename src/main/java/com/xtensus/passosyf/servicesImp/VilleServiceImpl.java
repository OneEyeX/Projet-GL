package com.xtensus.passosyf.servicesImp;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Gouvernerat;
import com.xtensus.passosyf.entities.Ville;
import com.xtensus.passosyf.repositories.VilleRepository;
import com.xtensus.passosyf.services.VilleService;

@Service
public class VilleServiceImpl implements VilleService {
	
	@Autowired
	VilleRepository villeDao;

	@Override
	public List<Ville> getAllVilles() {

		return villeDao.findAll();
	}


	@Override
	public Ville getVilleById(int id) {

		return villeDao.findById(id).get();
	}

	@Override
	public Ville saveVille(Ville ville) {

		return villeDao.save(ville);
	}

	@Override
	public void deleteVille(Ville ville) {

		villeDao.delete(ville);

	}

	@Override
	public void deleteVilleById(int id) {

		villeDao.deleteById(id);

	}

	@Override
	public Set<Ville> getVillesByGouvernerat(Gouvernerat gouvernerat) {
		
		return villeDao.findAllByGouvernerat(gouvernerat);
	}
	

}
