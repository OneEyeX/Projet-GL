package com.xtensus.passosyf.servicesImp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xtensus.passosyf.entities.TypeCahierDesCharges;
import com.xtensus.passosyf.repositories.TypeCahierDesChargesRepository;
import com.xtensus.passosyf.services.TypeCahierDesChargesService;

@Service
public class TypeCahierDesChargesServiceImpl implements TypeCahierDesChargesService{

	@Autowired
	TypeCahierDesChargesRepository typeCahierDesChargesDao;


	@Override
	public List<TypeCahierDesCharges> getAllTypeCahierDesCharges() {

		return typeCahierDesChargesDao.findAll();
	}



	@Override
	public TypeCahierDesCharges getTypeCahierDesChargesById(int id) {

		return typeCahierDesChargesDao.findById(id).get();
	}

	@Override
	public TypeCahierDesCharges saveTypeCahierDesCharges(TypeCahierDesCharges typeCahierDesCharges) {

		return typeCahierDesChargesDao.save(typeCahierDesCharges);
	}

	@Override
	public void deleteTypeCahierDesCharges(TypeCahierDesCharges typeCahierDesCharges) {

		typeCahierDesChargesDao.delete(typeCahierDesCharges);

	}

	@Override
	public void deleteTypeCahierDesChargesById(int id) {

		typeCahierDesChargesDao.deleteById(id);

	}

}
