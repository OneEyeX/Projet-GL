package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.SecteurActivite;
import com.xtensus.passosyf.repositories.SecteurActiviteRepository;
import com.xtensus.passosyf.services.SecteurActiviteService;

@Service
public class SecteurActiviteServiceImpl implements SecteurActiviteService {
	
	@Autowired
	SecteurActiviteRepository secteurActiviteDao;

	@Override
	public List<SecteurActivite> getAllSecteurActivites() {

		return secteurActiviteDao.findAll();
	}


	@Override
	public SecteurActivite getSecteurActiviteById(int id) {

		return secteurActiviteDao.findById(id).get();
	}

	@Override
	public SecteurActivite saveSecteurActivite(SecteurActivite secteurActivite) {

		return secteurActiviteDao.save(secteurActivite);
	}

	@Override
	public void deleteSecteurActivite(SecteurActivite secteurActivite) {

		secteurActiviteDao.delete(secteurActivite);

	}

	@Override
	public void deleteSecteurActiviteById(int id) {

		secteurActiviteDao.deleteById(id);

	}
}
