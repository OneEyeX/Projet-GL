package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.AppelOffres;
import com.xtensus.passosyf.entities.CahierCharges;

public interface CahierChargesService {

	public List<CahierCharges> getAllCahierCharges();
	
	public CahierCharges getCahierChargesById(int id);

	public CahierCharges saveCahierCharges(CahierCharges cahierCharges);

	public void deleteCahierCharges(CahierCharges cahierCharges);

	public void deleteCahierChargesById(int id);

	public List<CahierCharges> getCahierChargesByAppelOffre(AppelOffres appelOffre);

	public CahierCharges getCahierChargesByAppelOffreId(int aoId);

	float getCalculatedPrice(CahierCharges cahierCharges);

}
