package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.BlackListeMotif;
import com.xtensus.passosyf.repositories.BlackListeMotifRepository;
import com.xtensus.passosyf.services.BlackListeMotifService;

@Service
public class BlackListeMotifServiceImpl implements BlackListeMotifService {

	@Autowired
	BlackListeMotifRepository blackListeMotifDao;

	@Override
	public List<BlackListeMotif> getAllBlackListeMotifs() {

		return blackListeMotifDao.findAll();
	}


	@Override
	public BlackListeMotif getBlackListeMotifById(int id) {

		return blackListeMotifDao.findById(id).get();
	}

	@Override
	public BlackListeMotif saveBlackListeMotif(BlackListeMotif blackListeMotif) {

		return blackListeMotifDao.save(blackListeMotif);
	}

	@Override
	public void deleteBlackListeMotif(BlackListeMotif blackListeMotif) {

		blackListeMotifDao.delete(blackListeMotif);

	}

	@Override
	public void deleteBlackListeMotifById(int id) {

		blackListeMotifDao.deleteById(id);

	}
}
