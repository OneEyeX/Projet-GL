package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.Formejuridique;
import com.xtensus.passosyf.repositories.FormejuridiqueRepository;
import com.xtensus.passosyf.services.FormejuridiqueService;

@Service
public class FormejuridiqueServiceImpl implements FormejuridiqueService {

	@Autowired
	FormejuridiqueRepository formejuridiqueDao;

	@Override
	public List<Formejuridique> getAllFormejuridiques() {

		return formejuridiqueDao.findAll();
	}


	@Override
	public Formejuridique getFormejuridiqueById(int id) {

		return formejuridiqueDao.findById(id).get();
	}

	@Override
	public Formejuridique saveFormejuridique(Formejuridique formejuridique) {

		return formejuridiqueDao.save(formejuridique);
	}

	@Override
	public void deleteFormejuridique(Formejuridique formejuridique) {

		formejuridiqueDao.delete(formejuridique);

	}

	@Override
	public void deleteFormejuridiqueById(int id) {

		formejuridiqueDao.deleteById(id);

	}
}
