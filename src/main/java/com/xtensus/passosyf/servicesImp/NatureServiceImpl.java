package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Nature;
import com.xtensus.passosyf.repositories.NatureRepository;
import com.xtensus.passosyf.services.NatureService;

@Service 
public class NatureServiceImpl implements NatureService {
	
	@Autowired
	NatureRepository natureDao;


	@Override
	public List<Nature> getAllNatures() {

		return natureDao.findAll();
	}



	@Override
	public Nature getNatureById(int id) {

		return natureDao.findById(id).get();
	}

	@Override
	public Nature saveNature(Nature nature) {

		return natureDao.save(nature);
	}

	@Override
	public void deleteNature(Nature nature) {

		natureDao.delete(nature);

	}

	@Override
	public void deleteNatureById(int id) {

		natureDao.deleteById(id);

	}
	

}
