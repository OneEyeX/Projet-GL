package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.CategorieProjet;
import com.xtensus.passosyf.repositories.CategorieProjetRepository;
import com.xtensus.passosyf.services.CategorieProjetService;

@Service
public class CategorieProjetServiceImpl implements CategorieProjetService {

	@Autowired
	CategorieProjetRepository categorieProjetDao;

	@Override
	public List<CategorieProjet> getAllCategorieProjets() {

		return categorieProjetDao.findAll();
	}


	@Override
	public CategorieProjet getCategorieProjetById(int id) {

		return categorieProjetDao.findById(id).get();
	}

	@Override
	public CategorieProjet saveCategorieProjet(CategorieProjet categorieProjet) {

		return categorieProjetDao.save(categorieProjet);
	}

	@Override
	public void deleteCategorieProjet(CategorieProjet categorieProjet) {

		categorieProjetDao.delete(categorieProjet);

	}

	@Override
	public void deleteCategorieProjetById(int id) {

		categorieProjetDao.deleteById(id);

	}
}
