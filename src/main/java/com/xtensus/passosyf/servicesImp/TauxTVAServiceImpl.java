package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.TauxTVA;
import com.xtensus.passosyf.repositories.TauxTVARepository;
import com.xtensus.passosyf.services.TauxTVAService;

@Service
public class TauxTVAServiceImpl implements TauxTVAService  {
	@Autowired
	TauxTVARepository tauxTVADao;

	@Override
	public List<TauxTVA> getAllTauxTVAs() {

		return tauxTVADao.findAll();
	}


	@Override
	public TauxTVA getTauxTVAById(int id) {

		return tauxTVADao.findById(id).get();
	}

	@Override
	public TauxTVA saveTauxTVA(TauxTVA tauxTVA) {

		return tauxTVADao.save(tauxTVA);
	}

	@Override
	public void deleteTauxTVA(TauxTVA tauxTVA) {

		tauxTVADao.delete(tauxTVA);

	}

	@Override
	public void deleteTauxTVAById(int id) {

		tauxTVADao.deleteById(id);

	}
}
