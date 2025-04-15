package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.SoumissionnaireBlackList;
import com.xtensus.passosyf.repositories.SoumissionnaireBlackListRepository;
import com.xtensus.passosyf.services.SoumissionnaireBlackListService;

@Service
public class SoumissionnaireBlackListServiceImpl implements SoumissionnaireBlackListService {
	
	@Autowired
	SoumissionnaireBlackListRepository soumissionnaireBlackListDao;

	@Override
	public List<SoumissionnaireBlackList> getAllSoumissionnaireBlackLists() {

		return soumissionnaireBlackListDao.findAll();
	}


	@Override
	public SoumissionnaireBlackList getSoumissionnaireBlackListById(int id) {

		return soumissionnaireBlackListDao.findById(id).get();
	}

	@Override
	public SoumissionnaireBlackList saveSoumissionnaireBlackList(SoumissionnaireBlackList soumissionnaireBlackList) {

		return soumissionnaireBlackListDao.save(soumissionnaireBlackList);
	}

	@Override
	public void deleteSoumissionnaireBlackList(SoumissionnaireBlackList soumissionnaireBlackList) {

		soumissionnaireBlackListDao.delete(soumissionnaireBlackList);

	}

	@Override
	public void deleteSoumissionnaireBlackListById(int id) {

		soumissionnaireBlackListDao.deleteById(id);

	}
}
