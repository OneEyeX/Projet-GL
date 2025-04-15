package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Motif;
import com.xtensus.passosyf.repositories.MotifRepository;
import com.xtensus.passosyf.services.MotifService;

@Service
public class MotifServiceImpl implements MotifService{
	
	@Autowired
	MotifRepository motifDao;

	@Override
	public List<Motif> getAllMotifs() {

		return motifDao.findAll();
	}


	@Override
	public Motif getMotifById(int id) {

		return motifDao.findById(id).get();
	}

	@Override
	public Motif saveMotif(Motif motif) {

		return motifDao.save(motif);
	}

	@Override
	public void deleteMotif(Motif motif) {

		motifDao.delete(motif);

	}

	@Override
	public void deleteMotifById(int id) {

		motifDao.deleteById(id);

	}
}
