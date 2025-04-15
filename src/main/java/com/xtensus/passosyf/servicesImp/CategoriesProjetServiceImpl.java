package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.CategoriesProjet;
import com.xtensus.passosyf.repositories.CategoriesProjetRepository;
import com.xtensus.passosyf.services.CategoriesProjetService;

@Service
public class CategoriesProjetServiceImpl implements CategoriesProjetService {

	@Autowired
	CategoriesProjetRepository categoriesProjetDao;

	@Override
	public List<CategoriesProjet> getAllCategoriesProjets() {

		return categoriesProjetDao.findAll();
	}


	@Override
	public CategoriesProjet getCategoriesProjetById(int id) {

		return categoriesProjetDao.findById(id).get();
	}

	@Override
	public CategoriesProjet saveCategoriesProjet(CategoriesProjet categoriesProjet) {

		return categoriesProjetDao.save(categoriesProjet);
	}

	@Override
	public void deleteCategoriesProjet(CategoriesProjet categoriesProjet) {

		categoriesProjetDao.delete(categoriesProjet);

	}

	@Override
	public void deleteCategoriesProjetById(int id) {

		categoriesProjetDao.deleteById(id);

	}
}
