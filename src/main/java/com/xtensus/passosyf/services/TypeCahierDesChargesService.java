package com.xtensus.passosyf.services;

import java.util.List;

import com.xtensus.passosyf.entities.TypeCahierDesCharges;

public interface TypeCahierDesChargesService {
	
	public List<TypeCahierDesCharges> getAllTypeCahierDesCharges();
	
	public TypeCahierDesCharges getTypeCahierDesChargesById(int id);

	public TypeCahierDesCharges saveTypeCahierDesCharges(TypeCahierDesCharges typeCahierDesCharges);

	public void deleteTypeCahierDesCharges(TypeCahierDesCharges typeCahierDesCharges);

	public void deleteTypeCahierDesChargesById(int id);

}
