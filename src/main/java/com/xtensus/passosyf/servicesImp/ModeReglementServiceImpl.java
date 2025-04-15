package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.ModeReglement;
import com.xtensus.passosyf.repositories.ModeReglementRepository;
import com.xtensus.passosyf.services.ModeReglementService;


@Service
public class ModeReglementServiceImpl implements ModeReglementService{
	
	@Autowired
	ModeReglementRepository modeReglementDao;

	@Override
	public List<ModeReglement> getAllModeReglements() {

		return modeReglementDao.findAll();
	}


	@Override
	public ModeReglement getModeReglementById(int id) {

		return modeReglementDao.findById(id).get();
	}

	@Override
	public ModeReglement saveModeReglement(ModeReglement modeReglement) {

		return modeReglementDao.save(modeReglement);
	}

	@Override
	public void deleteModeReglement(ModeReglement modeReglement) {

		modeReglementDao.delete(modeReglement);

	}

	@Override
	public void deleteModeReglementById(int id) {

		modeReglementDao.deleteById(id);

	}
}
