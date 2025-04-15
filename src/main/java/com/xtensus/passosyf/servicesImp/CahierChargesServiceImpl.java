package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.CahierCharges;
import com.xtensus.passosyf.repositories.CahierChargesRepository;
import com.xtensus.passosyf.services.CahierChargesService;

@Service
public class CahierChargesServiceImpl implements CahierChargesService {
	
	@Autowired
	CahierChargesRepository cahierChargesDao;

	@Override
	public List<CahierCharges> getAllCahierCharges() {

		return cahierChargesDao.findAll();
	}


	@Override
	public CahierCharges getCahierChargesById(int id) {

		return cahierChargesDao.findById(id).get();
	}

	@Override
	public CahierCharges saveCahierCharges(CahierCharges cahierCharges) {

		return cahierChargesDao.save(cahierCharges);
	}

	@Override
	public void deleteCahierCharges(CahierCharges cahierCharges) {

		cahierChargesDao.delete(cahierCharges);

	}

	@Override
	public void deleteCahierChargesById(int id) {

		cahierChargesDao.deleteById(id);

	}


	@Override
	public List<CahierCharges> getCahierChargesByAppelOffre(AppelOffres appelOffre) {

		return cahierChargesDao.findByAppelOffre(appelOffre);
	}


	@Override
	public CahierCharges getCahierChargesByAppelOffreId(int aoId) {

		return cahierChargesDao.findByAppelOffre_AppelOffreId(aoId);
	}
}
